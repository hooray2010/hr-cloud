package com.hr.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hurui on 2018/1/27.
 */
@Configuration
public class RestConfig {
  
  @Bean
  public RestTemplate restTemplate() {
    //return new RestTemplate();
    //更改restTemplate实现
    return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
  }
  
}
