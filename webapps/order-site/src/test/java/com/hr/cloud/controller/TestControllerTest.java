package com.hr.cloud.controller;

import com.hr.cloud.OrderSiteApplication;
import com.hr.cloud.model.Apple;
import com.hr.cloud.model.Fruit;
import com.hr.cloud.model.TestModel;
import com.hr.cloud.service.testService.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by hurui on 2018/1/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(OrderSiteApplication.class)
@Slf4j
public class TestControllerTest {
  
  @Test
  public void testConstruct() {
    TestModel testModel = new TestModel();
    log.info(testModel.toString());
  }
  
  @Test
  public void testPECS() {
    List<? extends Fruit> eList = Arrays.asList(new Apple(), new Fruit());
    log.info(eList.get(0).toString());
    //elist.add(new Fruit());
    
    List<? super Fruit> sList = new ArrayList<>();
    sList.add(new Apple());
    sList.add(new Fruit());
    //get object
    log.info(sList.get(0).getClass().toString());
    
    Map<String, String> map = new HashMap<>();
    map.put("test_k", "test_v");
    map.forEach((k, v) -> log.info(k + " -- " + v));
  }
  
  @Test
  public void testSplit() {
    String str = "a,b,c,,";
    String[] ary = str.split(",");
    //预期大于 3，结果是 3
    log.info(ary.length + "");
  }
  
  @Test
  public void testVector() {
    List<String> list = Arrays.asList("test1", "test2");
    list = Collections.synchronizedList(list);
    log.warn(list.toString());
  }
  
  //******************************************************************************/
  
  /**
   * 接口下有多个实现类，须确定唯一bean
   */
  @Resource(type = BaseTestService.class, name = "baseTestService")
  private BaseInterface baseInterface;
  
  /**
   * 若有多个实现类，会报错无法确定唯一bean
   */
  //@Autowired
  //private AbstractService abstractService;
  
  @Autowired
  private BaseTestService baseTestService;
  
  @Autowired
  private TestService testService;
  
  /**
   * 注入接口的话，默认是它实现类 testService
   */
  @Autowired
  private TestInterface testInterface;
  
  @Autowired
  private ApplicationContext applicationContext;
  
  @Test
  public void testAutowired() {
    log.warn(baseInterface.get());
    //log.warn(abstractService.get());
    log.warn(baseTestService.get());
    log.warn(testService.get());
    log.warn(testInterface.test());
    
    TestService bean = applicationContext.getBean(TestService.class);
    log.warn(bean.toString());
    
    Play play = applicationContext.getBean(Play.class);
    log.warn(play.run());
  }
  
  @Autowired
  private RedisTemplate<String, String> stringRedisTemplate;
  
  @Autowired
  private RedisTemplate<String, Long> longRedisTemplate;
  
  @Test
  public void testType() {
    // TODO: 2018/4/19 StringRedisTemplate可以，自定义的实现如何获取泛型类型？？？
    //Type genericSuperclass = longRedisTemplate.getClass().getGenericSuperclass();
    Type genericSuperclass = stringRedisTemplate.getClass().getGenericSuperclass();
    ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
    for (Type actualType : actualTypeArguments) {
      log.warn(actualType.getTypeName());
    }
  }
  
}
