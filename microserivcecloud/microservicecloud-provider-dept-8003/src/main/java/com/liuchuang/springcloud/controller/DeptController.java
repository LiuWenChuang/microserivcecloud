package com.liuchuang.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.liuchuang.springcloud.entities.Dept;
import com.liuchuang.springcloud.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService service;

	@Autowired
	private DiscoveryClient client;

	@PostMapping(value = "/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}

	@GetMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}

	@GetMapping(value = "/dept/list")
	public List<Dept> list() {
		return service.list();
	}

	@GetMapping(value = "/dept/client")
	public Object client() {
		// 通过 获取当前保存在 eureka并且将信息提供给 消费者 进行快速排查出问题的 微服务
		List<String> servicename = client.getServices();
		System.out.println("+++++++++++++++++++" + servicename);
		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance serviceInstance : srvList) {
			System.out.println("微服务所在编号" + serviceInstance.getServiceId() + "主机名:" + serviceInstance.getHost() + "端口："
					+ serviceInstance.getPort() + "URl:" + serviceInstance.getUri()+"当前的请求是否是https:"+serviceInstance.isSecure());
		}
		return this.client;
	}
}
