package com.hr.cloud.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.cloud.CloudApplication;
import com.hr.cloud.entity.OrderEntity;
import com.hr.cloud.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by hurui on 2017/12/28.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Import(CloudApplication.class)
public class OrderServiceTest {
  
  private static final ObjectMapper MAPPER = new ObjectMapper();
  
  @Autowired
  private OrderMapper orderMapper;
  
  @Test
  public void findAll() throws Exception {
    List<OrderEntity> orderEntityList = orderMapper.findAll();
    for (OrderEntity orderEntity : orderEntityList) {
      System.err.println(orderEntity);
    }
  }
  
}