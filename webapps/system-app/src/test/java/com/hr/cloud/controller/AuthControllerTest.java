package com.hr.cloud.controller;

import com.hr.cloud.SystemApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hurui on 2018/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(SystemApp.class)
@Slf4j
public class AuthControllerTest {
  
  @Autowired
  private LoadBalancerClient loadBalancerClient;
  
  @Test
  public void login() throws Exception {
    String serviceId = "USER-APP";
    for (int i = 0; i < 100; i++) {
      ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
      log.warn("第" + (i + 1) + "次：" + serviceInstance.getHost() + ": " + serviceInstance.getPort());
    }
  }
  
}