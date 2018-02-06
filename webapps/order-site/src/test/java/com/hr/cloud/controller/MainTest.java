package com.hr.cloud.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * Created by hurui on 2018/2/6.
 */
@Slf4j
public class MainTest {
  
  public static void main(String[] args) {
    log.warn(UUID.randomUUID().toString().substring(0, 6));
  }
  
}
