package com.hr.cloud.config;

import com.hr.cloud.OrderApp;
import com.hr.cloud.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hurui on 2018/1/27.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Import(OrderApp.class)
@Slf4j
public class RedisConfigTest {
  
  private static final String TEST_PREFIX = "test:";
  
  @Autowired
  private RedisTemplate<String, String> stringRedisTemplate;
  
  @Autowired
  private RedisTemplate<String, Long> longRedisTemplate;
  
  @Autowired
  private RedisTemplate<String, Object> genericJsonTemplate;
  
  @Test
  public void stringRedisTemplate() throws Exception {
    ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
    String k1 = TEST_PREFIX + "1";
    String k2 = TEST_PREFIX + "2";
    valueOperations.set(k1, "test1");
    valueOperations.set(k2, "test2");
    log.warn(valueOperations.get(k1));
    log.warn(valueOperations.get(k2));
  }
  
  @Test
  public void longRedisTemplate() throws Exception {
    ValueOperations<String, Long> valueOperations = longRedisTemplate.opsForValue();
    String k3 = TEST_PREFIX + "3";
    String k4 = TEST_PREFIX + "4";
    valueOperations.set(k3, 3L);
    valueOperations.set(k4, 4L);
    log.warn(valueOperations.get(k3).toString());
    log.warn(valueOperations.get(k4).toString());
    longRedisTemplate.delete(k3);
    longRedisTemplate.delete(k4);
  }
  
  @Test
  public void objectRedisTemplate() throws Exception {
    HashOperations<String, Object, Object> hashOperations = genericJsonTemplate.opsForHash();
    String k5 = TEST_PREFIX + "5";
    hashOperations.put(k5, k5, new OrderEntity());
    log.warn(hashOperations.get(k5, k5).toString());
  }
  
}