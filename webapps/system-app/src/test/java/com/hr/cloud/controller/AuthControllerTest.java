package com.hr.cloud.controller;

import com.hr.cloud.SystemApp;
import com.hr.cloud.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

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
  
  @Autowired
  private RestTemplate restTemplate;
  
  @Test
  public void login() throws Exception {
    String serviceId = "USER-APP";
    for (int i = 0; i < 100; i++) {
      ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
      log.warn("第" + (i + 1) + "次：" + serviceInstance.getHost() + ": " + serviceInstance.getPort());
    }
  }
  
  @Test
  public void loginByRestTemplate() throws Exception {
    String serviceId = "USER-APP";
    User user = restTemplate.getForObject("http://" + serviceId + "/user/findOne/" + 2, User.class);
    log.warn("login user = {}", user);
  }
  
}