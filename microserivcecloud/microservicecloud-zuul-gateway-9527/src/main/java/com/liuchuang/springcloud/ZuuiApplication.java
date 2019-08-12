package com.liuchuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuuiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuuiApplication.class, args);
	}
}
