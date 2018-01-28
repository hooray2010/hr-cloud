package com.hr.cloud.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.cloud.OrderSiteApplication;
import com.hr.cloud.entity.OrderEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hurui on 2017/12/28.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Import(OrderSiteApplication.class)
public class OrderServiceTest {
  
  private static final ObjectMapper MAPPER = new ObjectMapper();
  
  @Autowired
  private OrderService orderService;
  
  @Test
  public void findAll() throws Exception {
    List<OrderEntity> orderEntityList = orderService.findAll();
    System.err.println(orderEntityList);
  }
  
  @Test
  public void findOrderByIdIn() throws Exception {
    List<Long> orderIds = Arrays.asList(1L, 2L, 3L, 4L);
    List<OrderEntity> orderEntityList = orderService.findOrderByIdIn(orderIds);
    System.err.println(orderEntityList);
  }
  
  @Test
  public void testParam() {
    ParameterNameDiscoverer parameterNameDiscoverer = new StandardReflectionParameterNameDiscoverer();
    Method[] methods = OrderEntity.class.getMethods();
    for (Method method : methods) {
      Parameter[] parameters = method.getParameters();
      if (parameters.length > 0) {
        //无法获取父类方法参数名
        //String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
        //System.err.println("~~~~~~~~~~parameterNames = " + parameterNames[0]);
        
        System.out.println("--------------method name = " + method.getName());
        System.out.println("--------------param name = " + parameters[0].getName());
        System.out.println("--------------param[0] = " + parameters[0]);
      }
    }
  }
  
}