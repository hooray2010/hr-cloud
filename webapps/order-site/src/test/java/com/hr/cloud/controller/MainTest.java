package com.hr.cloud.controller;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Created by hurui on 2018/2/6.
 */
@Slf4j
public class MainTest {
  
  public static void main(String[] args) throws InterruptedException {
    //log.warn(UUID.randomUUID().toString().substring(0, 6));
    BigDecimal decimal = new BigDecimal(1.23456789);
    log.warn(decimal.toString());
    
    //wait会释放锁, 报错
    //Thread.currentThread().wait();
    Thread.sleep(5000);
    
    log.warn("main end...");
  }
  
}
