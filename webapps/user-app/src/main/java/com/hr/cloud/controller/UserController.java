package com.hr.cloud.controller;

import com.hr.cloud.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hurui on 2018/6/2.
 */
@RestController
@RequestMapping("user")
public class UserController {
  
  @GetMapping("findOne/{userId}")
  public User findUserById(@PathVariable long userId) {
    User user = new User();
    user.setId(userId);
    user.setName("hurui");
    user.setPassword("123456");
    return user;
  }
  
}
