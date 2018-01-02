package com.hr.cloud.mapper;

import com.hr.cloud.CloudApplication;
import com.hr.cloud.entity.OrderEntity;
import com.hr.cloud.util.StringService;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;
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
  
  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;
  
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
    List<OrderEntity> orderEntityList = orderMapper.findOrderByIds(Arrays.asList(1L, 2L));
    System.err.println(orderEntityList);
  }
  
  @Test
  public void findOneOrder() throws Exception {
    //可以查看mybatis配置信息
    Configuration configuration = sqlSessionTemplate.getConfiguration();
    
    System.err.println("根据id查找一个映射: findOne " + configuration.getMappedStatement("findOne").getId());
    //重复的sql id, 必须用 类名 + 方法名
    //System.err.println("根据id查找一个映射: findAll " + configuration.getMappedStatement("findAll").getId());
    
    //别名全部转为小写!!!
    Class<?> type = configuration.getTypeAliasRegistry().getTypeAliases().get("order");
    System.err.println("type OrderEntity = " + type.getCanonicalName());
    System.err.println("type OrderEntity = " + type.getSimpleName());
    System.err.println("type OrderEntity = " + type.getName());
    System.err.println("type OrderEntity = " + type.getTypeName());
    
    //所有映射sql
    Collection<String> mappedStatementNames = configuration.getMappedStatementNames();
    for (String name : mappedStatementNames) {
      System.err.println("所有映射: " + name);
    }
    
    OrderEntity OrderEntity = orderMapper.findOne(1L);
    System.err.println("查询结果: " + OrderEntity);
  }
}