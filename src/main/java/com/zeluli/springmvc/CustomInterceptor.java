package com.zeluli.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CustomInterceptor extends HandlerInterceptorAdapter {
	//请求处理之前执行的方法
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("在请求处理之前执行该方法-preHandle");
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	//在请求处理之后执行该方法
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("在请求处理之后执行该方法-postHandle");
		long startTime = (Long) request.getAttribute("startTime");
		long handleTime = System.currentTimeMillis() -startTime;
		System.out.println("本次请求花费了：" + handleTime + "ms\n");
	}
	
	//请求处理完成所执行的方法
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("请求处理完成所执行的方法-afterCompletion");
	}
	
}
