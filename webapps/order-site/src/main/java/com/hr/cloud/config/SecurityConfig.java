package com.hr.cloud.config;

import com.hr.cloud.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by hurui on 2018/1/13.
 */
@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private AuthenticationManagerBuilder authenticationManagerBuilder;
  
  @Autowired
  private AuthProvider authProvider;
  
  protected void configure(HttpSecurity http) throws Exception {
    
    log.debug("init http security config...");
    
    http.authorizeRequests()
        //.anyRequest().authenticated() //任何请求登录后可以访问
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() //允许任何options请求
        .antMatchers("/order/**").authenticated()
        //.and().formLogin() //表单登录, 跳转页面
        .and().httpBasic(); //http basic 加密
    
    //Disable csrf filter. Because our operation requires customized headers.
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.csrf().disable();
    
    authenticationManagerBuilder.authenticationProvider(authProvider);
  }
  
  @Component
  public static class AuthProvider implements AuthenticationProvider {
    
    @Autowired
    private AuthService authService;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
      String loginName = authentication.getName();
      String accessToken = authentication.getCredentials().toString();
      return authService.authenticate(loginName, accessToken);
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
      return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
  }
  
}
