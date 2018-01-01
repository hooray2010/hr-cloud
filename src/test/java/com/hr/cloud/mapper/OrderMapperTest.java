package com.hr.cloud.mapper;

import com.hr.cloud.CloudApplication;
import com.hr.cloud.entity.OrderEntity;
import com.hr.cloud.util.StringService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hurui on 2018/1/1.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Import(CloudApplication.class)
public class OrderMapperTest {
  
  @Autowired
  private OrderMapper orderMapper;
  
  @Test
  public void findAll() throws Exception {
  }
  
  @Test
  public void findOrderById() throws Exception {
    OrderEntity order = orderMapper.findOrderById(1L);
    System.err.println(order);
  }
  
  @Test
  public void findOrderByIdIn() throws Exception {
    List<OrderEntity> orderEntityList = orderMapper.findOrderByIdIn(StringService.getSqlIdIn(Arrays.asList(1L, 2L)));
    System.err.println(orderEntityList);
  }
  
  @Test
  public void findOrderByIds() throws Exception {
    List<OrderEntity> orderEntityList = orderMapper.findOrderByIds(StringService.getSqlIdIn(Arrays.asList(1L, 2L)));
    System.err.println(orderEntityList);
  }
}