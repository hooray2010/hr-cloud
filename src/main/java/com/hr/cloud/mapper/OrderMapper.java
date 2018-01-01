package com.hr.cloud.mapper;

import com.hr.cloud.entity.OrderEntity;
import com.hr.cloud.provider.OrderSqlProvider;
import com.hr.cloud.util.SelectInLanguageDriver;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by hurui on 2017/12/28.
 */
@Mapper
public interface OrderMapper {
  
  /**
   * 查询所有订单
   *
   * @return
   */
  @Select("select * from qmxbb_order")
  @Results({
      @Result(property = "id", column = "id", javaType = Long.class),
      @Result(property = "code", column = "order_code", javaType = String.class),
      @Result(property = "createAt", column = "create_at", javaType = Date.class)
  })
  List<OrderEntity> findAll();
  
  /**
   * 查询一个订单, 根据id
   *
   * @param orderId
   * @return
   */
  @Select("select * from qmxbb_order where id = #{orderId}")
  @Results({
      @Result(property = "id", column = "id", javaType = Long.class),
      @Result(property = "code", column = "order_code", javaType = String.class),
      @Result(property = "createAt", column = "create_at", javaType = Date.class)
  })
  OrderEntity findOrderById(@Param("orderId") long orderId);
  
  /**
   * 查询订单, 动态sql
   *
   * @param orderIds
   * @return
   */
  @SelectProvider(type = OrderSqlProvider.class, method = "selectOrderByIdIn")
  //@Select("select * from qmxbb_order where id in #{orderIds}")
  @Results({
      @Result(property = "id", column = "id", javaType = Long.class),
      @Result(property = "code", column = "order_code", javaType = String.class),
      @Result(property = "createAt", column = "create_at", javaType = Date.class)
  })
  List<OrderEntity> findOrderByIdIn(@Param("orderIds") String orderIds);
  
  @Lang(SelectInLanguageDriver.class)
  @Select("select * from qmxbb_order where id in (#{orderIds})")
  @Results({
      @Result(property = "id", column = "id", javaType = Long.class),
      @Result(property = "code", column = "order_code", javaType = String.class),
      @Result(property = "createAt", column = "create_at", javaType = Date.class)
  })
  List<OrderEntity> findOrderByIds(@Param("orderIds") List<Long> orderIds);
  
  OrderEntity findOneOrder(long orderId);
}
