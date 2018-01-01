package com.hr.cloud.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by hurui on 2018/1/1.
 */
public class OrderSqlProvider {
  
  /**
   * 查询订单, 动态sql
   *
   * @param orderIds
   * @return
   */
  public String selectOrderByIdIn(@Param("orderIds") String orderIds) {
    String sql = new SQL() {
      {
        SELECT("id, order_code, create_at");
        FROM("qmxbb_order");
        if (orderIds != null && ! orderIds.isEmpty()) {
          WHERE("id in " + orderIds);
        }
      }
    }.toString();
    System.err.println("sql: " + sql);
    return sql;
  }
  
}
