package com.zeluli.springmvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {
	@RequestMapping(value="/rest", produces="text/plain;charset=UTF-8")
	public String restTest(){
		System.out.println("\n处理REST请求\n");
		return "我是RestTestController返回的值";
	}
}
