package com.hr.cloud.service;

import com.hr.cloud.entity.OrderEntity;
import com.hr.cloud.mapper.OrderMapper;
import com.hr.cloud.util.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hurui on 2017/12/28.
 */
@Service
public class OrderService {
  
  @Autowired
  private OrderMapper orderMapper;
  
  public List<OrderEntity> findAll() {
    return orderMapper.findAll();
  }
  
  /**
   * find by id in
   *
   * @param orderIds
   * @return
   */
  public List<OrderEntity> findOrderByIdIn(List<Long> orderIds) {
    return orderMapper.findOrderByIdIn(StringService.getSqlIdIn(orderIds));
  }
  
}
