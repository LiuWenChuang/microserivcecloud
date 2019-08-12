package com.liuchuang.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptApplication02 {
	public static void main(String[] args){
		SpringApplication.run(DeptApplication02.class, args);
	}
}
