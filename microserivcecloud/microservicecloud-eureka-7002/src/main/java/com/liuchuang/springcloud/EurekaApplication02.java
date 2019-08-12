package com.liuchuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//声明是一个注册服务
public class EurekaApplication02 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication02.class, args);
	}
}
