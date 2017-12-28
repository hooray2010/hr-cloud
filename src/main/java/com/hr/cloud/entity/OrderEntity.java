package com.hr.cloud.entity;

import java.util.Date;

/**
 * Created by hurui on 2017/12/28.
 */
public class OrderEntity {
  
  private long id;
  
  private String code;
  
  private Date createAt;
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getCode() {
    return code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public Date getCreateAt() {
    return createAt;
  }
  
  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }
  
  @Override
  public String toString() {
    return "OrderEntity{" +
        "id=" + id +
        ", code='" + code + '\'' +
        ", createAt=" + createAt +
        '}';
  }
}
