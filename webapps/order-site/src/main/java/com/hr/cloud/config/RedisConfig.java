package com.hr.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/**
 * Created by hurui on 2018/1/13.
 */
@Configuration
public class RedisConfig {
  
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
    template.setKeySerializer(new GenericJackson2JsonRedisSerializer());
    template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
    template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    return template;
  }
  
}
