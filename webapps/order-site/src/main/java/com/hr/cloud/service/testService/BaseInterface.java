package com.hr.cloud.service.testService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hurui on 2018/2/7.
 */
@Service
public interface BaseInterface {
  
  //@Transactional
  String get();
  
}
