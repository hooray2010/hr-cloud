package com.hr.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by hurui on 2017/12/25.
 */
@SpringBootApplication
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
//@MapperScan("com.hr.cloud.mapper")
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class OrderSiteApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(OrderSiteApplication.class);
  }
  
}
