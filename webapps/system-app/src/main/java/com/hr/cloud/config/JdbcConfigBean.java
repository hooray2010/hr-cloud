package com.hr.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by hurui on 2018/6/3.
 */
@RefreshScope
@Component
public class JdbcConfigBean {
  
  @Value("${jdbc.url}")
  private String url;
  
  @Value("${jdbc.username}")
  private String username;
  
  @Value("${jdbc.password}")
  private String password;
  
  @Value("${jdbc.driverClassName}")
  private String driverClassName;
  
  public String getUrl() {
    return url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getDriverClassName() {
    return driverClassName;
  }
  
  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }
  
  @Override
  public String toString() {
    return "JdbcConfigBean{" +
        "\nurl='" + url + '\'' +
        ", \nusername='" + username + '\'' +
        ", \npassword='" + password + '\'' +
        ", \ndriverClassName='" + driverClassName + '\'' +
        '}';
  }
  
}

