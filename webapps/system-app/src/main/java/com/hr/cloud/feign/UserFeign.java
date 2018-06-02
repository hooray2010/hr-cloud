package com.hr.cloud.feign;

import com.hr.cloud.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by hurui on 2018/6/2.
 */
@FeignClient("USER-APP")
public interface UserFeign {
  
  @GetMapping(value = "/user/findOne/{userId}")
  User findUserById(@PathVariable("userId") long userId);
  
}
