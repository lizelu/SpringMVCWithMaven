package com.zeluli.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {
	@RequestMapping("/advice")
	public String getMsg() {
		throw new IllegalArgumentException("非常抱歉，参数有误");
	}
}
