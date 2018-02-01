package com.example.readnew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
public class ReadnewApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(ReadnewApplication.class, args);
	}


	/**
	 * 添加试图控制器
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	/**
	 * 参数解析器
	 * @param argumentResolvers
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new ReaderHandlerMethodArgumentResolver());
	}


}
