package com.hr.cloud.service.job;

import com.hr.cloud.entity.OrderEntity;
import com.hr.cloud.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.DateService;

import java.util.List;

/**
 * Created by hurui on 2018/1/27.
 */
@Component
@Slf4j
public class QuartzService {
  
  private static final String JOB_NAME_PREFIX = "order_job";
  private static final String GROUP_NAME = "order_job_group:";
  
  @Autowired
  private Scheduler scheduler;
  
  @Autowired
  private OrderMapper orderMapper;
  
  //@PostConstruct
  public void init() throws SchedulerException {
    
    List<OrderEntity> orderEntityList = orderMapper.findAll();
    
    for (OrderEntity orderEntity : orderEntityList) {
      
      String identity = JOB_NAME_PREFIX + orderEntity.getId();
      
      //jobData
      JobDetail jobDetail = JobBuilder.newJob(OrderJob.class)
          .withIdentity(identity, GROUP_NAME)
          .build();
      JobDataMap jobDataMap = jobDetail.getJobDataMap();
      jobDataMap.put("prop", orderEntity.getCode());
      log.info("定时任务初始化，入参 = " + orderEntity);
      
      //trigger
      String cron = DateService.getCron(DateService.TodayEnd());
      CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
      CronTrigger cronTrigger = TriggerBuilder.newTrigger()
          .withIdentity(identity, GROUP_NAME)
          .withSchedule(scheduleBuilder)
          .build();
      
      try {
        scheduler.scheduleJob(jobDetail, cronTrigger);
      } catch (SchedulerException e) {
        log.warn("过期任务初始化异常: " + e.getMessage());
      }
    }
  }
  
}
