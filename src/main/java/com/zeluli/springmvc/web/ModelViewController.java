package com.zeluli.springmvc.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelViewController {
	@RequestMapping("/view")
	public ModelAndView exception(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("message");//error页面
		modelAndView.addObject("message", "Hello world"); //错误信息
		return modelAndView;
	}
}
