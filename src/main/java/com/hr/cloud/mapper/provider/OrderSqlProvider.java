package com.hr.cloud.mapper.provider;

import com.hr.cloud.util.StringService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * 纯注解的方式生成sql, 相当于mapper.xml文件的作用
 * <p>
 * Created by hurui on 2018/1/1.
 */
public class OrderSqlProvider {
  
  /**
   * 查询订单, 动态sql
   *
   * @param orderIds
   * @return
   */
  public String selectOrderByIdIn(@Param("orderIds") final String orderIds) {
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
  
  public String countOrderProduction(List<Long> orderIds) {
    String orderIdsSql = StringService.getSqlIdIn(orderIds);
    if (orderIds == null || orderIds.isEmpty()) {
      return null;
    }
    String sql = "SELECT  " +
        "  temp.orderId AS orderId,  " +
        "  temp.CODE AS CODE,  " +
        "  sum( temp.totalCount ) AS totalCount   " +
        "FROM  " +
        "  (  " +
        "  SELECT  " +
        "    po.order_id AS orderId,  " +
        "    tmp.channel_group_code AS CODE,  " +
        "    count(*) as totalCount   " +
        "  FROM  " +
        "    qmxbb_policy_order po  " +
        "    LEFT JOIN newtank_thp_insure_policy ip ON ip.policy_order_id = po.id  " +
        "    LEFT JOIN newtank_plg_activity_channel ac ON ac.id = ip.activity_channel_id  " +
        "    LEFT JOIN (  " +
        "    SELECT  " +
        "      oq.id,  " +
        "      oq.channel_group_code,  " +
        "      p.channel_id,  " +
        "      oq.order_id " +
        "    FROM  " +
        "      qmxbb_order_quantity oq  " +
        "      LEFT JOIN qmxbb_channel_package p ON oq.channel_group_code = p.`code`   " +
        "    WHERE  " +
        "      oq.order_id in " + orderIdsSql + "   " +
        "      AND oq.channel_group_code IS NOT NULL   " +
        "      AND oq.region_code IS NULL   " +
        "      AND oq.min_age IS NULL   " +
        "      AND oq.sex IS NULL   " +
        "    ) tmp ON ac.parent_channel_id = tmp.channel_id  AND tmp.order_id = po.order_id " +
        "  WHERE  " +
        "    po.order_id in " + orderIdsSql +
        "  GROUP BY  " +
        "    tmp.id UNION ALL  " +
        "  SELECT  " +
        "    po.order_id AS orderId,  " +
        "    tmp.channel_group_code AS CODE,  " +
        "    count(*) as totalCount   " +
        "  FROM  " +
        "    qmxbb_policy_order po  " +
        "    LEFT JOIN newtank_thp_insure_policy ip ON ip.policy_order_id = po.id  " +
        "    LEFT JOIN newtank_plg_activity_channel ac ON ac.id = ip.activity_channel_id  " +
        "    LEFT JOIN newtank_plg_activity_channel ac2 ON ac2.id = ac.parent_channel_id  " +
        "    LEFT JOIN (  " +
        "    SELECT  " +
        "      oq.id,  " +
        "      oq.channel_group_code,  " +
        "      p.channel_id, " +
        "      oq.order_id   " +
        "    FROM  " +
        "      qmxbb_order_quantity oq  " +
        "      LEFT JOIN qmxbb_channel_package p ON oq.channel_group_code = p.CODE   " +
        "    WHERE  " +
        "      oq.order_id in " + orderIdsSql + "   " +
        "      AND oq.channel_group_code IS NOT NULL   " +
        "      AND oq.region_code IS NULL   " +
        "      AND oq.min_age IS NULL   " +
        "      AND oq.sex IS NULL   " +
        "    ) tmp ON ac2.parent_channel_id = tmp.channel_id  AND tmp.order_id = po.order_id " +
        "  WHERE  " +
        "    po.order_id in " + orderIdsSql +
        "    AND tmp.channel_group_code IS NOT NULL   " +
        "  GROUP BY  " +
        "    tmp.id   " +
        "  ) temp   " +
        "GROUP BY  " +
        "  temp.CODE;";
    String s = new SQL() {
      {
        SELECT("temp.orderId AS orderId");
        SELECT("temp.CODE AS CODE");
        SELECT("temp.CODE AS CODE");
        SELECT("sum( temp.totalCount ) AS totalCount");
        FROM();
      }
    }.toString();
    return s;
  }
  
}
