package com.hr.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hurui on 2017/12/25.
 */
@SpringBootApplication
//@MapperScan("com.hr.cloud.mapper")
public class CloudApplication {
  
  @Bean
  public RestTemplate restTemplate() {
    //return new RestTemplate();
    //更改restTemplate实现
    return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
  }
  
  public static void main(String[] args) {
    SpringApplication.run(CloudApplication.class);
  }
  
}
