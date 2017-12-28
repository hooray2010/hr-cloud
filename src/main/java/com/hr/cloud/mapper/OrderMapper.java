package com.hr.cloud.mapper;

import com.hr.cloud.entity.OrderEntity;
import com.hr.cloud.service.OrderService;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Date;
import java.util.List;

/**
 * Created by hurui on 2017/12/28.
 */
public interface OrderMapper {
  
  @Select("select * from qmxbb_order")
  @Results({
      @Result(property = "id", column = "id", javaType = Long.class),
      @Result(property = "code", column = "order_code", javaType = String.class),
      @Result(property = "createAt", column = "create_at", javaType = Date.class)
  })
  List<OrderEntity> findAll();
  
  @SelectProvider(type = OrderService.class, method = "selectOrderByIdIn")
  @Results({
      @Result(property = "id", column = "id", javaType = Long.class),
      @Result(property = "code", column = "order_code", javaType = String.class),
      @Result(property = "createAt", column = "create_at", javaType = Date.class)
  })
  List<OrderEntity> findOrderByIdIn(List<Long> orderIds);
}
