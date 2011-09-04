package org.fssle.sample.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(LoggerInterceptor.class);

    //before the actual handler will be executed
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {

        logger.info("request.getRequestURL: " + request.getRequestURL());
        logger.info("request.getContextPath: " + request.getContextPath());
        logger.info("request.getPathInfo: " + request.getPathInfo());
        logger.info("request.getQueryString: " + request.getQueryString());
        logger.info("request.getRequestURI: " + request.getRequestURI());
        logger.info("request.getServerName: " + request.getServerName());
        logger.info("request.getServerPort: " + request.getServerPort());

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        return true;
    }

    //after the handler is executed
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView)
            throws Exception {

        long startTime = (Long) request.getAttribute("startTime");

        long endTime = System.currentTimeMillis();

        long executeTime = endTime - startTime;

        //modified the exisitng modelAndView
        modelAndView.addObject("executeTime", executeTime);

        //log it
        if (logger.isDebugEnabled()) {
            logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");
        }
    }
}