package com.zeluli.springmvc.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeluli.model.StudentModel;

@Controller
@RequestMapping(value="/route", produces="text/plain;charset=UTF-8")
public class RouteController {
	
	//将路由映射到相应的jsp页面
	//访问地址：http://localhost:8080/SpringMVCWithMaven/route/
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	//访问地址： http://localhost:8080/SpringMVCWithMaven/route/sub1
	@RequestMapping(value="/sub1")
	@ResponseBody
	public String sub1(HttpServletRequest request) {
		return "请求地址：" + request.getRequestURI();
	}
	
	//访问地址：http://localhost:8080/SpringMVCWithMaven/route/sub2/app/ios/resource
	//路径参数
	@RequestMapping(value="/sub2/{value1}/{value2}/resource")
	@ResponseBody
	public String sub2(HttpServletRequest request, @PathVariable String value1, @PathVariable String value2) {
		return "请求地址：" + request.getRequestURI() + " 移动端：" + value1 + " 平台："+ value2;
	}
	
	//获取请求参数
	//http://localhost:8080/SpringMVCWithMaven/route/sub3?param=哈哈
	@RequestMapping(value = "/sub3")
	@ResponseBody
	public String sub3(HttpServletRequest request, String param) {
		return  "请求地址" + request.getRequestURI() + " get参数 = " + param;
	}
	
	//将请求直接映射为Model
	//http://localhost:8080/SpringMVCWithMaven/route/sub4?studentNumber=12&name=zeluli
	@RequestMapping(value = "/sub4")
	@ResponseBody 
	public String sub4(HttpServletRequest request, StudentModel student) {
		return  "请求地址:" + request.getRequestURI() + " 参数studentNumber = " + student.getStudentNumber() + "   studentName:" + student.getName();
	}
	
	//返回json数据
	//http://localhost:8080/SpringMVCWithMaven/route/getjson?studentNumber=12&name=zeluli
	@RequestMapping(value="/getjson", produces="application/json;charset=UTF-8")
	@ResponseBody 
	public StudentModel getJson(StudentModel student) {
		return student;
	}
	
	//返回XML数据
	//http://localhost:8080/SpringMVCWithMaven/route/getxml?studentNumber=12&name=zeluli
	@RequestMapping(value="/getxml", produces="application/xml;charset=UTF-8")
	@ResponseBody 
	public StudentModel getXML(StudentModel student) {
		return student;
	}
	
	//多个地址路由到同一个方法上
	//http://localhost:8080/SpringMVCWithMaven/route/name1
	//http://localhost:8080/SpringMVCWithMaven/route/name2
	@RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request) {
		return  "请求地址:" + request.getRequestURI() + " 已经被访问了！";
	}
}
