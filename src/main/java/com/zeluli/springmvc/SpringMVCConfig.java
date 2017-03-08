package com.zeluli.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.zeluli.springmvc")
public class SpringMVCConfig  extends WebMvcConfigurerAdapter {
	//路由映射的快捷设置
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/indextest").setViewName("/index");
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}	
	
	//创建自定义拦截器的对象
	@Bean
	public CustomInterceptor customInterceptor(){
		return new CustomInterceptor();
	}
	
	//添加自定义拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(customInterceptor());
//		registry.addInterceptor(...);
	}
}
