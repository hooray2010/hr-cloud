package com.hr.cloud.service;

import com.hr.cloud.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hurui on 2018/1/29.
 */
@Service
@Slf4j
public class AuthService {
  
  private static final String ACCESS_TOKEN_PREFIX = "access_token:";
  
  @Autowired
  private RedisTemplate<String, String> redisTemplate;
  
  public Authentication authenticate(String loginName, String accessToken) {
    
    ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    String accessTokenKey = ACCESS_TOKEN_PREFIX + loginName;
    String cachedAccessToken = valueOperations.get(accessTokenKey);
    
    // 传入的accessToken和存储的相同, 则认证成功
    if (accessToken.equals(cachedAccessToken)) {
      // 赋予访问权限
      List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
      grantedAuthorities.add(new SimpleGrantedAuthority(Role.MANAGER.name()));
      return new UsernamePasswordAuthenticationToken(loginName, accessToken, grantedAuthorities);
    }
    if (loginName == null) {
      loginName = "Anonymous";
    }
    return new AnonymousAuthenticationToken("key", loginName, AuthorityUtils.createAuthorityList(Role.GUEST.name()));
  }
  
}
