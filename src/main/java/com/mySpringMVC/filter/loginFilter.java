package com.mySpringMVC.filter;

import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器需要在web.xml配置文件中进行配置
 *
 *  <filter>
 *      <filter-name>loginFilter</filter-name>
 *      <filter-class>com.mySpringMVC.filter.loginFilter</filter-class> 处理类
 *      <init-param>  处理类参数
 *          <param-name>par</param-name>
 *          <param-value>parTest</param-value>
 *      </init-param>
 *  </filter>
 *
 *  <filter-mapping>
 *      <filter-name>loginFilter</filter-name>
 *      <url-pattern>/springmvc/view/2</url-pattern>  过滤url
 *  </filter-mapping>
 */
public class loginFilter implements Filter {
    private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
    private final Logger logger = Logger.getLogger(loginFilter.class);
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        if (request!=null&&request.getAttribute(FILTERED_REQUEST)!=null) {
//            chain.doFilter(request,response);
//        } else {
//            request.setAttribute(FILTERED_REQUEST,Boolean.TRUE);
//            //HttpServletRequest httpServletRequest= (HttpServletRequest) request;
//            chain.doFilter(request,response);
//        }
//        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//        Object o = httpServletRequest.getSession().getAttribute("user");
//        if (o == null) return;

        if (((HttpServletRequest)request).getSession().getAttribute("user") == null) {
            response.getOutputStream().print("请重新登录！");
            ((HttpServletResponse)response).sendRedirect("../../mySpringMVC/index.jsp");
        } else chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
