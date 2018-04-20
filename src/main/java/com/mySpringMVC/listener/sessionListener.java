package com.mySpringMVC.listener;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

/**
 *  监听需要在web.xml配置文件中进行配置
 *
 *  Session监听
 *  <listener>
 *      <description>SessionListener</description>
 *      <listener-class>com.mySpringMVC.listener.sessionListener</listener-class>
 *  </listener>
 */
public class sessionListener implements HttpSessionListener {
    private static final Logger LOGGER = Logger.getLogger(sessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOGGER.debug("Listener-创建Session：" + new Date());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().invalidate();
        LOGGER.debug("Listener-销毁Session：" + new Date());
    }
}
