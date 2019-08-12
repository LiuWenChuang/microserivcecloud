package com.atguigu.springcloud.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liuchuang.springcloud.entities.Dept;
import com.liuchuang.springcloud.service.DeptServiceFeign;

@RestController
public class DeptController_Consumer {

	// private static final String REST_URL_PREFIX = "http://localhost:8001";
	// 使用固定的IP进行访问
	// private static final String REST_URL_PREFIX =
	// "http://MICROSERVICECLOUD-DEPT";//通过eureka 注册的微服务名称进行访问

	/**
	 * 2.1 使用 RestTemplate 进行访问 2.2 frign 进行访问
	 * 
	 * @param dept
	 * @return
	 */
	@Autowired
	private DeptServiceFeign service;

	// @Autowired
	// private RestTemplate restTemplate;

	@RequestMapping(value = "/consumer/add/dept",method=RequestMethod.POST)
	public Boolean addConsumer(Dept dept) {
		return service.add(dept);
	}

	@GetMapping(value = "/consumer/select/list")
	public List<Dept> list() {
		System.out.println("22222222222222222");
		return service.list();
	}

	@GetMapping(value = "/consumer/select/{deptid}")
	public Dept selectByid(@PathVariable("deptid") Long deptid) {
		return service.get(deptid);
	}

	@GetMapping(value = "/consumer/dept/client")
	public Object client() {
		return service.client();
	}

}
