package com.hr.cloud.model;

import lombok.Data;

/**
 * Created by hurui on 2018/1/31.
 */
@Data
public class TestModel {
  
  private String name = "test name1";
  
  private int age = 10;
  
  private String desc;
  
  public TestModel() {
    this("test name2", 20);
    desc = getName() + ", " + getAge();
  }
  
  public TestModel(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
