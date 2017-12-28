package com.hr.cloud.controller;

import com.hr.cloud.entity.OrderEntity;
import com.hr.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hurui on 2017/12/28.
 */
@RestController
@RequestMapping("order")
public class OrderController {
  
  @Autowired
  private OrderService orderService;
  
  @GetMapping("findAll")
  public List<OrderEntity> findAllOrder() {
    return orderService.findAll();
  }
  
}
