package com.zeluli.springmvc.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelViewController {
	@RequestMapping("/view")
	public ModelAndView message(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("message");
		modelAndView.addObject("message_key", "Hello world"); 
		return modelAndView;
	}
}
