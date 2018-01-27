package com.hr.cloud.config;

import com.hr.cloud.CloudApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by hurui on 2018/1/27.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Import(CloudApplication.class)
public class RedisConfigTest {
  
  
  
  @Test
  public void stringRedisTemplate() throws Exception {
  }
  
  @Test
  public void longRedisTemplate() throws Exception {
  }
  
  @Test
  public void objectRedisTemplate() throws Exception {
  }
  
}