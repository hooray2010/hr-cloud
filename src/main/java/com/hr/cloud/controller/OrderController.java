package com.hr.cloud.controller;

import com.hr.cloud.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hurui on 2017/12/28.
 */
@RestController
@RequestMapping("order")
public class OrderController {
  
  @Autowired
  private OrderMapper orderMapper;
  
  @GetMapping("findAll")
  public Object findAllOrder() {
    return orderMapper.findAll();
  }
  
}
