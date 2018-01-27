package service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by hurui on 2017/5/18.
 */
public class SpringUtils implements ApplicationContextAware {
  
  private static ApplicationContext applicationContext;
  
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringUtils.applicationContext = applicationContext;
  }
  
  // 获取applicationContext
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }
  
  // 通过name获取Bean
  public static Object getBean(String name) {
    return getApplicationContext().getBean(name);
  }
  
  // 通过class获取Bean
  public static <T> T getBean(Class<T> clazz) {
    return getApplicationContext().getBean(clazz);
  }
  
  // 通过name以及Clazz返回指定的Bean
  public static <T> T getBean(String name, Class<T> clazz) {
    return getApplicationContext().getBean(name, clazz);
  }
  
  
}