package com.hr.cloud.service.testService;

import org.springframework.stereotype.Service;

/**
 * Created by hurui on 2018/2/7.
 */
@Service
public class TestService extends BaseService {
  
  @Override
  public String get() {
    return "test service";
  }
  
}
