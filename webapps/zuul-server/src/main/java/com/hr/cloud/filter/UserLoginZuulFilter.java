package com.hr.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hurui on 2018/6/2.
 */
@Component
public class UserLoginZuulFilter extends ZuulFilter {
  
  /**
   * a)	pre：请求在被路由之前执行
   * b)	routing：在路由请求时调用
   * c)	post：在routing和error过滤器之后调用
   * d)	error：处理请求时发生错误调用
   *
   * @return
   */
  @Override
  public String filterType() {
    return "pre";
  }
  
  /**
   * 定义过滤器的执行顺序，数字越小优先级越高。
   *
   * @return
   */
  @Override
  public int filterOrder() {
    return 0;
  }
  
  @Override
  public boolean shouldFilter() {
    return true;
  }
  
  @Override
  public Object run() {
    RequestContext requestContext = RequestContext.getCurrentContext();
    HttpServletRequest request = requestContext.getRequest();
    String token = request.getParameter("token");
    if (StringUtils.isEmpty(token)) {
      requestContext.setSendZuulResponse(false); // 过滤该请求，不对其进行路由
      requestContext.setResponseStatusCode(401); // 设置响应状态码
      return null;
    }
    return null;
  }
  
}
