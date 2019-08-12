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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	@Autowired
	private DeptService service;

	@Autowired
	private DiscoveryClient client;

	@PostMapping(value = "/dept/add")
	@HystrixCommand(fallbackMethod="addDept")//标注在接口上可以 提供 出现错误时的返回按照返回的数据类型 fallbackMethod 处理的方法名
	public boolean add(@RequestBody Dept dept) {
	    if(dept != null) {
	    	 throw new RuntimeException();
	    }
		return service.add(dept);
	}
	//处理异常类
	public boolean addDept(@RequestBody Dept dept){
		System.out.println("添加方法出现问题");
		return false;
	}

	@GetMapping(value = "/dept/get/{id}")
	@HystrixCommand(fallbackMethod="getbydeptid")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = service.get(id);
		if(dept == null) {
			throw new RuntimeException();
		}
		return dept;
	}
	
	public Dept getbydeptid(@PathVariable("id") Long id) {
		Dept dept = new Dept();
		System.out.println("编号为"+id+"的值不存在");
		return dept;
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
