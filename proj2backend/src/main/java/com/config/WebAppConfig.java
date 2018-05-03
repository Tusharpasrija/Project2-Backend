package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//dispatcher servlet
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com")
public class WebAppConfig extends WebMvcConfigurerAdapter{

	public WebAppConfig(){
		System.out.println("webappconfig is instantiated");
	}
	
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver commonsMultipartResolver(){
		CommonsMultipartResolver commonMultipartResolver=new CommonsMultipartResolver();
		return commonMultipartResolver;
	}
}
