package com.hr.cloud.service.testService;

import com.hr.cloud.config.aop.UserEventAspect;
import org.springframework.stereotype.Service;

/**
 * Created by hurui on 2018/2/7.
 */
@Service
public interface BaseInterface {
  
  //@UserEventAspect.UserEventPoint(value = "测试: BaseInterface, 方法: get()")
  String get();
  
}
