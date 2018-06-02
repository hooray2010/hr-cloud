package com.hr.cloud.service;

import com.hr.cloud.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hurui on 2018/6/2.
 */
@Slf4j
@Service
public class UserService {
  
  @Autowired
  private RestTemplate restTemplate;
  
  @HystrixCommand(fallbackMethod = "findUserByIdFallbackMethod") // 进行容错处理
  public User findUserById(long userId) {
    String serviceId = "USER-APP";
    User user = restTemplate.getForObject("http://" + serviceId + "/user/findOne/" + userId, User.class);
    log.warn("login user = {}", user);
    return user;
  }
  
  public User findUserByIdFallbackMethod(long userId) {
    User user = new User();
    user.setId(userId);
    user.setName("unknown");
    return user;
  }
  
}
