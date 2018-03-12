package com.hr.cloud.service.testService;

import com.hr.cloud.config.aop.UserEventAspect;
import org.springframework.stereotype.Service;

/**
 * Created by hurui on 2018/2/7.
 */
@Service
public abstract class AbstractService implements BaseInterface {
  
  @Override
  //@UserEventAspect.UserEventPoint(value = "测试: AbstractService, 方法: get()")
  public String get() {
    return "abstract service";
  }
  
}
