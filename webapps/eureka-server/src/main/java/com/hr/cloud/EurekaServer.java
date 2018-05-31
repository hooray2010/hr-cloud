package com.hr.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by hurui on 2018/5/31.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {
  
  public static void main(String[] args) {
    SpringApplication.run(EurekaServer.class);
  }
  
}
