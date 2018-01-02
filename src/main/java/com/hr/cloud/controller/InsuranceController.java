package com.hr.cloud.controller;

import com.hr.cloud.entity.InsuranceEntity;
import com.hr.cloud.mapper.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hurui on 2018/1/2.
 */
@RestController
public class InsuranceController {
  
  @Autowired
  private InsuranceMapper insuranceMapper;
  
  /**
   * 查找所有保险
   *
   * @return
   */
  @GetMapping("insurance/findAll")
  public List<InsuranceEntity> findAll() {
    return insuranceMapper.findAll();
  }
  
}
