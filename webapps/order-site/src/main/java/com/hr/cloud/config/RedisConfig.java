package com.hr.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

/**
 * Created by hurui on 2018/1/13.
 */
@Configuration
public class RedisConfig {
  
  //string
  private static final RedisSerializer stringRedisSerializer = new StringRedisSerializer();
  
  //object --> string
  private static final RedisSerializer longRedisSerializer = new GenericToStringSerializer(Long.TYPE);
  
  //object --> json, 无须类型参数
  private static final RedisSerializer genericJsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
  //type --> json, 须类型参数
  private static final RedisSerializer jsonRedisSerializer = new Jackson2JsonRedisSerializer(Long.TYPE);
  
  //速度快, 但占用空间大
  //使用JDK的序列化手段(须实现serializable接口，ObjectInputStream，ObjectOutputStream)，数据以字节流存储
  private static final RedisSerializer jdkRedisSerializer = new JdkSerializationRedisSerializer();
  
  @Bean
  public RedisTemplate<String, String> stringRedisTemplate(RedisConnectionFactory connectionFactory) {
    final RedisTemplate<String, String> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);
    return template;
  }
  
  @Bean
  public RedisTemplate<String, Long> longRedisTemplate(RedisConnectionFactory connectionFactory) {
    final RedisTemplate<String, Long> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);
    return template;
  }
  
  @Bean
  public RedisTemplate<String, Object> objectRedisTemplate(RedisConnectionFactory connectionFactory) {
    final RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);
    RedisSerializer redisSerializer = new GenericJackson2JsonRedisSerializer();
    template.setKeySerializer(redisSerializer);
    template.setHashKeySerializer(redisSerializer);
    template.setValueSerializer(redisSerializer);
    return template;
  }
  
}
