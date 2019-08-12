package com.liuchuang.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptApplication03 {
	public static void main(String[] args){
		SpringApplication.run(DeptApplication03.class, args);
	}
}
