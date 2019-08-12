package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.ribbon.MyRibbonRule;

@SpringBootApplication
@EnableEurekaClient//开启 eureka 的客户端
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MyRibbonRule.class)//指定单独给那一个微服务定制负载均衡的算法  ， 具体实现的类(注:不能在springboot 主目录下进行，另起一个文件夹)
public class ConsumerApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
