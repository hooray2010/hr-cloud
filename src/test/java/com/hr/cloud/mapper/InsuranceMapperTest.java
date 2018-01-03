package com.hr.cloud.mapper;

import com.hr.cloud.CloudApplication;
import com.hr.cloud.entity.InsuranceEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by hurui on 2018/1/2.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Import(CloudApplication.class)
public class InsuranceMapperTest {
  
  @Autowired
  private InsuranceMapper insuranceMapper;
  
  @Autowired
  private ApplicationContext applicationContext;
  
  @Test
  public void findAll() throws Exception {
    List<InsuranceEntity> insuranceEntityList = insuranceMapper.findAll();
    for (InsuranceEntity insuranceEntity : insuranceEntityList) {
      System.err.println(insuranceEntity);
    }
  }
  
  @Test
  public void findOne() throws Exception {
    InsuranceEntity insuranceEntity = insuranceMapper.findOne(1L);
    System.err.println(insuranceEntity);
  }
  
  @Test
  public void testAppContext() throws Exception {
    System.err.println(applicationContext.getApplicationName());
    
    AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
    
    System.err.println(applicationContext.getDisplayName());
    
    System.err.println(applicationContext.getBeanDefinitionCount());
    
    String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
    System.err.println(beanDefinitionNames[0].toString());
    
    Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Service.class);
    
    InsuranceEntity insuranceEntity = insuranceMapper.findOne(1L);
    System.err.println(insuranceEntity);
  }
  
}