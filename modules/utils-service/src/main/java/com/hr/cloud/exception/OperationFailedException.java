package com.hr.cloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hurui on 2018/2/6.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400
public class OperationFailedException extends Exception {
  
  public OperationFailedException(String message) {
    super(message);
  }
  
}