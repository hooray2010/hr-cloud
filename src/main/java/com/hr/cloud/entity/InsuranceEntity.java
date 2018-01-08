package com.hr.cloud.entity;

import com.hr.cloud.model.Status;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * Created by hurui on 2018/1/2.
 */
@Alias("Insurance")
@Data
public class InsuranceEntity {
  
  private long id;
  
  private String name;
  
  private String shortName;
  
  private String interfaceCode;
  
  private Status status;
}
