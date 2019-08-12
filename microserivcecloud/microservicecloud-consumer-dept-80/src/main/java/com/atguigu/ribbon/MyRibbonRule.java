package com.atguigu.ribbon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MyRibbonRule{
	@Bean
	public IRule iRule() {
		return new MyRule();
	}
	
     
}
