package com.hr.cloud.controller;

import com.hr.cloud.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hurui on 2018/6/1.
 */
@RestController("auth")
public class AuthController {
  
  @GetMapping("login")
  public User login() {
    User user = new User();
    user.setName("hurui");
    user.setPassword("123456");
    return user;
  }
  
}
