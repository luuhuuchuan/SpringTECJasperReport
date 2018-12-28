package com.ck.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
        .addResourceHandler("/resources/**")
        .addResourceLocations("classpath:/static/"); 
	}
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bean= new ReloadableResourceBundleMessageSource();
		bean.addBasenames("classpath:messages");
		return bean;
	}
}