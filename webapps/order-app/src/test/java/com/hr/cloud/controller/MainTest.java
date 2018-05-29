package com.hr.cloud.controller;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Created by hurui on 2018/2/6.
 */
@Slf4j
public class MainTest {
  
  public static void main(String[] args) throws InterruptedException {
    //testThread();
    
    //System.getProperties().list(System.out);
    
    log.warn(add(7, 8) + "");
  }
  
  /**
   * 位运算求和
   *
   * @param num1
   * @param num2
   * @return
   */
  private static int add(int num1, int num2) {
    if (num2 == 0) {
      return num1;
    }
    int sum = num1 ^ num2;
    int carry = (num1 & num2) << 1;
    return add(sum, carry);
  }
  
  /**
   * 测试线程
   *
   * @throws InterruptedException
   */
  private static void testThread() throws InterruptedException {
    //log.warn(UUID.randomUUID().toString().substring(0, 6));
    BigDecimal decimal = new BigDecimal(1.23456789);
    log.warn(decimal.toString());
    
    //wait会释放锁, 报错
    //Thread.currentThread().wait();
    Thread.sleep(5000);
    
    log.warn("main end...");
  }
  
}
