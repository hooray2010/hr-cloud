package com.hr.cloud.controller;

import com.hr.cloud.entity.InsuranceEntity;
import com.hr.cloud.mapper.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hurui on 2018/1/2.
 */
@RestController
@RequestMapping("insurance")
public class InsuranceController {
  
  @Autowired
  private InsuranceMapper insuranceMapper;
  
  @Autowired
  private ApplicationContext applicationContext;
  
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
    return insuranceMapper.findOne(insuranceId);
  }
}
