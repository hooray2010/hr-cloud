package com.hr.cloud.service.testService;

import org.springframework.stereotype.Service;

/**
 * Created by hurui on 2018/2/7.
 */
@Service
public class BaseTestService extends AbstractService {
  
  @Override
  public String get() {
    return "base service";
  }
  
}
