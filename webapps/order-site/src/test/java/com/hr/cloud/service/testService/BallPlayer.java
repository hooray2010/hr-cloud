package com.hr.cloud.service.testService;

import com.hr.cloud.config.aop.UserEventAspect;
import org.springframework.stereotype.Component;

/**
 * Created by hurui on 2018/2/9.
 */
@Component
public class BallPlayer implements Play {
  
  @Override
  @UserEventAspect.UserEventPoint(value = "方法说明: Ball Player run")
  public String run() {
    return "Ball Player";
  }
  
}
