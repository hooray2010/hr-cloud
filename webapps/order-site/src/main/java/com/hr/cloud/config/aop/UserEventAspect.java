package com.hr.cloud.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Created by hurui on 2018/2/9.
 */
@Aspect
@Component
@Slf4j
public class UserEventAspect {
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  public @interface UserEventPoint {
    String value() default "";
  }
  
  @Pointcut("@annotation(com.hr.cloud.config.aop.UserEventAspect.UserEventPoint)")
  public void pointCut() {
  }
  
  @AfterReturning("pointCut()")
  public void handleUserEvent(JoinPoint joinPoint) {
    Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
    String value = method.getAnnotation(UserEventPoint.class).value();
    log.warn("aop 调用方法: " + joinPoint.getSignature().getDeclaringTypeName() + " - " + method.getName());
    log.warn("aop 操作说明: " + value);
  }
  
}
