package com.hr.cloud.controller;

import com.hr.cloud.entity.OrderEntity;
import com.hr.cloud.mapper.OrderMapper;
import com.hr.cloud.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hurui on 2017/12/28.
 */
@RestController
@RequestMapping("order")
public class OrderController {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
  
  @Autowired
  private OrderService orderService;
  
  @Autowired
  private OrderMapper orderMapper;
  
  @GetMapping("findAll")
  public List<OrderEntity> findAllOrder() {
    return orderService.findAll();
  }
  
  @GetMapping("findOne/orderId/{orderId}")
  public OrderEntity findAllOrder(@PathVariable long orderId) {
    
    System.out.println(LOGGER.isDebugEnabled());
    LOGGER.info("test log...");
    Logger logger = LOGGER;
    
    return orderMapper.findOne(orderId);
  }
  
}
