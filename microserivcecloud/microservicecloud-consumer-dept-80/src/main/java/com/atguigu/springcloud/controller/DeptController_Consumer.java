package com.atguigu.springcloud.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.liuchuang.springcloud.entities.Dept;


@RestController
public class DeptController_Consumer {

//	private static final String REST_URL_PREFIX = "http://localhost:8001"; 使用固定的IP进行访问
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";//通过eureka 注册的微服务名称进行访问


	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/consumer/add/dept")
	public Boolean addConsumer(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/consumer/select/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

	@GetMapping(value = "/consumer/select/{deptid}")
	public Dept selectByid(@PathVariable("deptid") Long deptid) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + deptid, Dept.class);
	}
	@GetMapping(value = "/consumer/dept/client")
	public Object client() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/client/", Object.class);
	}

}