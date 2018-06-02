package com.hr.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by hurui on 2018/6/2.
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulServer {
  
  public static void main(String[] args) {
    SpringApplication.run(ZuulServer.class);
  }
  
}
