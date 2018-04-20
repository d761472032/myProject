package com.mySpringMVC.interceptor;

import com.mySpringMVC.filter.loginFilter;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 *
 * <mvc:interceptors>
 *  <mvc:interceptor>
 *      <mvc:mapping path="/springmvc/view/2"/>   拦截url
 *      <bean class="com.mySpringMVC.interceptor.loginInterceptor" />  处理类
 *  </mvc:interceptor>
 * </mvc:interceptors>
 */
public class loginInterceptor implements HandlerInterceptor {
    private final Logger logger = Logger.getLogger(loginFilter.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //logger.debug("Interceptor-postHandle:" + this.getClass());
        if (httpServletRequest.getSession().getAttribute("user") == null) {
            modelAndView.addObject("msg", "请登录！");
            //modelAndView.getModel().put("msg", "请登录！");
            modelAndView.setViewName("../../index");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
