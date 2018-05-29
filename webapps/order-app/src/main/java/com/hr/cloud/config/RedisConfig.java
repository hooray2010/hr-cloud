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
  private static final RedisSerializer stringSerializer = new StringRedisSerializer();
  
  //object --> string
  private static final RedisSerializer longSerializer = new GenericToStringSerializer(Long.TYPE);
  
  //object --> json, 无须类型参数
  private static final RedisSerializer genericJsonSerializer = new GenericJackson2JsonRedisSerializer();
  //type --> json, 须类型参数
  private static final RedisSerializer jsonSerializer = new Jackson2JsonRedisSerializer(Long.TYPE);
  
  //速度快, 但占用空间大
  //使用JDK的序列化手段(须实现serializable接口，ObjectInputStream，ObjectOutputStream)，数据以字节流存储
  private static final RedisSerializer jdkSerializer = new JdkSerializationRedisSerializer();

//  //已存在实现类stringRedisTemplate, 这段代码不会执行!
//  @Bean
//  public RedisTemplate<String, String> stringRedisTemplate(RedisConnectionFactory connectionFactory) {
//    final RedisTemplate<String, String> template = new RedisTemplate<>();
//    template.setConnectionFactory(connectionFactory);
//    template.setKeySerializer(stringSerializer);
//    template.setValueSerializer(stringSerializer);
//    return template;
//  }
  
  @Bean
  public RedisTemplate<String, Long> longRedisTemplate(RedisConnectionFactory connectionFactory) {
    final RedisTemplate<String, Long> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);
    template.setKeySerializer(stringSerializer);
    template.setValueSerializer(longSerializer);
    return template;
  }
  
  @Bean
  public RedisTemplate<String, Object> objectRedisTemplate(RedisConnectionFactory connectionFactory) {
    final RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);
    template.setKeySerializer(stringSerializer);
    template.setValueSerializer(genericJsonSerializer);
    template.setHashKeySerializer(stringSerializer);
    template.setHashValueSerializer(genericJsonSerializer);
    return template;
  }
  
}
