package com.zeluli.springmvc.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(value=Exception.class)	//拦截所有的Exception
	public ModelAndView exception(Exception exception, WebRequest request) {
		ModelAndView modelAndView = new ModelAndView("error");//error页面
		modelAndView.addObject("errorMessage", exception.getMessage()); //错误信息
		System.out.println(exception.getMessage());
		return modelAndView;
	}
}
