package service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by hurui on 2018/1/27.
 */
@UtilityClass
public class JsonService {
  
  private static Logger LOGGER = LoggerFactory.getLogger(JsonService.class);
  
  private static final ObjectMapper MAPPER = new ObjectMapper();
  
  static {
    //忽略为null字段
    MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    
    //忽略不包含字段
    MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    //字段为null不抛异常
    MAPPER.disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
  }
  
  /**
   * to json
   *
   * @param object
   * @return
   */
  public static String toJson(Object object) {
    try {
      return MAPPER.writeValueAsString(object);
    } catch (IOException e) {
      LOGGER.error(e.getMessage());
    }
    return "";
  }
  
  /**
   * to object
   *
   * @param json
   * @param clazz
   * @param <T>
   * @return
   */
  public static <T> T toObject(String json, Class<T> clazz) {
    try {
      return MAPPER.readValue(json, clazz);
    } catch (IOException e) {
      LOGGER.error(json + "错误" + e.getMessage());
    }
    return null;
  }
  
  /**
   * to object list
   *
   * @param json
   * @param clazz
   * @param <T>
   * @return
   */
  public static <T> List<T> toObjectList(String json, Class<T> clazz) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    JavaType type = mapper.getTypeFactory().constructParametricType(List.class, clazz);
    try {
      return mapper.readValue(json, type);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  /**
   * 下划线 转 驼峰实体, 忽略对象中不存在的字段
   *
   * @param json
   * @param clazz
   * @param <T>
   * @return
   */
  public static <T> T toCamelCaseObject(String json, Class<T> clazz) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    try {
      return mapper.readValue(json, clazz);
    } catch (IOException e) {
      LOGGER.error(e.getMessage());
    }
    return null;
  }
  
}
