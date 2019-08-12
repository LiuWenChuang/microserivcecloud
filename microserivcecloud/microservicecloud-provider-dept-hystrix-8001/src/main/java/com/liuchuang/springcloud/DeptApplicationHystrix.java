package com.liuchuang.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//添加hystrix的熔断
public class DeptApplicationHystrix {
	public static void main(String[] args){
		SpringApplication.run(DeptApplicationHystrix.class, args);
	}
}
