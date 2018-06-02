package com.hr.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Created by hurui on 2018/5/30.
 */
@EnableFeignClients
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class SystemApp {
  
  public static void main(String[] args) {
    SpringApplication.run(SystemApp.class);
  }
  
}
