package service.excel.model;

import service.excel.annotation.ExcelCell;

import java.lang.reflect.Field;

/**
 * Created by LiuQi on 2017/12/18 0018.
 */
public class ExcelMetaData {
  
  private ExcelCell excelCell;
  
  private Field field;
  
  private Object value;
  
  public ExcelCell getExcelCell() {
    return excelCell;
  }
  
  public void setExcelCell(ExcelCell excelCell) {
    this.excelCell = excelCell;
  }
  
  public Field getField() {
    return field;
  }
  
  public void setField(Field field) {
    this.field = field;
  }
  
  public Object getValue() {
    return value;
  }
  
  public void setValue(Object value) {
    this.value = value;
  }
}
