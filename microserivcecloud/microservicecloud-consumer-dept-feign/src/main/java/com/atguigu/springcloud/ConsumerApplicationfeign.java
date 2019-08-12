package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient//开启 eureka 的客户端
@EnableFeignClients(basePackages={"com.liuchuang.springcloud"})
//@ComponentScan("com.liuchuang.springcloud") 千万不要加上
public class ConsumerApplicationfeign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ConsumerApplicationfeign.class, args);
	}

}
