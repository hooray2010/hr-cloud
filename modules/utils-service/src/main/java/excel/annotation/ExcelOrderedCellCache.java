package excel.annotation;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public enum ExcelOrderedCellCache {
  
  instance;
  
  private Map<Class, List<ExcelCell>> orderCellsMap = new ConcurrentHashMap<>();
  private Map<Class, List<Field>> orderedFieldsMap = new ConcurrentHashMap<>();
  
  public List<ExcelCell> getOrderedCells(Class clazz) {
    return this.orderCellsMap.get(clazz);
  }
  
  public void addOrderedCells(Class clazz, List<ExcelCell> excelCells) {
    if (! CollectionUtils.isEmpty(excelCells)) {
      this.orderCellsMap.put(clazz, excelCells);
    }
  }
  
  public List<Field> getOrderedFields(Class clazz) {
    return this.orderedFieldsMap.get(clazz);
  }
  
  public void addOrderedFields(Class clazz, List<Field> fields) {
    if (! CollectionUtils.isEmpty(fields)) {
      this.orderedFieldsMap.put(clazz, fields);
    }
  }
  
}




