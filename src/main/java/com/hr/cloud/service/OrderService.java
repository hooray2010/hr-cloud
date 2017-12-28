package com.hr.cloud.service;

import com.hr.cloud.entity.OrderEntity;
import com.hr.cloud.mapper.OrderMapper;
import org.apache.ibatis.jdbc.SQL;
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
  
  /**
   * 拼接sql ids, (1,2,3)
   */
  public String getSqlIdIn(List<Long> idList) {
    String cIds = " (";
    for (int i = 0; i < idList.size(); i++) {
      if (i == 0) {
        cIds = cIds + idList.get(i);
      } else {
        cIds = cIds + ',' + idList.get(i);
      }
    }
    return cIds + ") ";
  }
  
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
    return orderMapper.findOrderByIdIn(orderIds);
  }
  
  public String selectOrderByIdIn(List<Long> orderIds) {
    return new SQL() {
      {
        SELECT("order_code");
        FROM("qmxbb_order");
        if (orderIds != null && ! orderIds.isEmpty()) {
          WHERE("id in" + getSqlIdIn(orderIds));
        }
      }
    }.toString();
  }
}
