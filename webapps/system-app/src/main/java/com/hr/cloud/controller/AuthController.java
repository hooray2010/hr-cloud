package com.hr.cloud.controller;

import com.hr.cloud.config.JdbcConfigBean;
import com.hr.cloud.model.User;
import com.hr.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hurui on 2018/6/1.
 */
@RequestMapping("auth")
@RestController
public class AuthController {
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private JdbcConfigBean jdbcConfigBean;
  
  @GetMapping("login/{userId}")
  public User login(@PathVariable long userId) {
    return userService.findUserById(userId);
  }
  
  @GetMapping(value = "getConfig")
  public String getConfig() {
    return this.jdbcConfigBean.toString();
  }
  
}
