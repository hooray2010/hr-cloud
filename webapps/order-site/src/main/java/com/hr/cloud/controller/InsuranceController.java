package com.hr.cloud.controller;

import com.hr.cloud.entity.InsuranceEntity;
import com.hr.cloud.mapper.InsuranceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by hurui on 2018/1/2.
 */
@Slf4j
@RestController
@RequestMapping("insurance")
public class InsuranceController {
  
  @Autowired
  private InsuranceMapper insuranceMapper;
  
  /**
   * 查找所有保险
   *
   * @return
   */
  @GetMapping("findAll")
  public List<InsuranceEntity> findAll() {
    return insuranceMapper.findAll();
  }
  
  @GetMapping("findOne/insuranceId/{insuranceId}")
  public InsuranceEntity findOne(@PathVariable long insuranceId) {
    
    testType();
    
    return insuranceMapper.findOne(insuranceId);
  }
  
  @Autowired
  private RedisTemplate<String, String> stringRedisTemplate;
  
  @Autowired
  private RedisTemplate<String, Long> longRedisTemplate;
  
  public void testType() {
    //Type genericSuperclass = longRedisTemplate.getClass().getGenericSuperclass();
    Type[] genericInterfaces = longRedisTemplate.getClass().getGenericInterfaces();
    ParameterizedType parameterizedType = (ParameterizedType) genericInterfaces[0];
    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
    for (Type actualType : actualTypeArguments) {
      log.warn(actualType.getTypeName());
    }
  }
  
}
