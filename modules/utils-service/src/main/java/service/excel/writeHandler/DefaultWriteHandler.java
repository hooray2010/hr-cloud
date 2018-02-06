package service.excel.writeHandler;


import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.util.List;


public class DefaultWriteHandler<T> extends AbstractWriteHandler<T> {
  
  public DefaultWriteHandler() {
    super(new SXSSFWorkbook(1000));
  }
  
  @Override
  protected int writeHeader(Workbook wb, Sheet sheet, T t, int titleLineNum) {
    Row row = sheet.createRow(titleLineNum);
    row.setHeight((short) 0x180);
    
    int colNum = 0;
    CellStyle cellStyle = createHeadCellStyle(wb);
    List<String> cellTitles = excelCellUtils.getOrderedCellTitle(t);
    
    for (String title : cellTitles) {
      // sheet.autoSizeColumn(colNum);
      
      Cell cell = row.createCell(colNum++);
      cell.setCellValue(title);
      cell.setCellStyle(cellStyle);
    }
    
    return titleLineNum;
  }
  
  
  /**
   * 创建标题Style
   *
   * @param wb
   * @return
   */
  private CellStyle createHeadCellStyle(Workbook wb) {
    // 生成一个字体
    Font font = wb.createFont();
    font.setColor(IndexedColors.BLACK.index);
    font.setFontHeightInPoints((short) 12);
    font.setBold(true);
    
    CellStyle style = wb.createCellStyle();
    style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
    
    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    style.setFont(font);
    
    return style;
  }
  
}
