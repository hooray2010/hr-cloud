package com.hr.cloud.entity;

import com.hr.cloud.model.Status;
import org.apache.ibatis.type.Alias;

/**
 * Created by hurui on 2018/1/2.
 */
@Alias("Insurance")
public class InsuranceEntity {
  
  private long id;
  
  private String name;
  
  private String shortName;
  
  private String interfaceCode;
  
  private Status status;
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getShortName() {
    return shortName;
  }
  
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }
  
  public String getInterfaceCode() {
    return interfaceCode;
  }
  
  public void setInterfaceCode(String interfaceCode) {
    this.interfaceCode = interfaceCode;
  }
  
  public Status getStatus() {
    return status;
  }
  
  public void setStatus(Status status) {
    this.status = status;
  }
  
  @Override
  public String toString() {
    return "InsuranceEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", shortName='" + shortName + '\'' +
        ", interfaceCode='" + interfaceCode + '\'' +
        ", status=" + status +
        '}';
  }
}
