package com.hr.cloud.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Created by hurui on 2017/12/28.
 */
@Alias("Order")
@Data
public class OrderEntity {
  
  private long id;
  
  private String code;
  
  private Date createAt;
  
}
