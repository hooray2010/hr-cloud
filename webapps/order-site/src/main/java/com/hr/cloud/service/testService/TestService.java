package com.hr.cloud.service.testService;

import com.hr.cloud.config.aop.UserEventAspect;
import org.springframework.stereotype.Service;

/**
 * Created by hurui on 2018/2/7.
 */
@Service
public class TestService extends BaseTestService implements TestInterface {
  
  @UserEventAspect.UserEventPoint(value = "测试: test service, 方法: get()")
  @Override
  public String get() {
    return "test service";
  }
  
  @Override
  public String test() {
    return "test service";
  }
}
