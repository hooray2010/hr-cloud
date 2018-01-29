package com.hr.cloud.model;

/**
 * Created by hurui on 2018/1/29.
 */
public enum Role {
  
  ADMIN(0),
  MANAGER(1),
  USER(2),
  GUEST(3);
  
  private int value;
  
  Role(int value) {
    this.value = value;
  }
  
  public int getValue() {
    return value;
  }
  
  public void setValue(int value) {
    this.value = value;
  }
  
}
