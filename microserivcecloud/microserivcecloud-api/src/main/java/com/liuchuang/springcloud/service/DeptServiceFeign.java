package com.liuchuang.springcloud.service;

import java.util.List;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liuchuang.springcloud.entities.Dept;


//@FeignClient(value="MICROSERVICECLOUD-DEPT") //通过服务名称访问对应的 服务路径controller//
@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptServiceFeignFallbackFactory.class) //通过服务名称访问对应的 服务路径controller//和hystrix 结合 使用熔断和降级
public interface DeptServiceFeign {
	
	@RequestMapping(value = "/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept);

	@RequestMapping(value = "/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id);

	@RequestMapping(value = "/dept/list",method=RequestMethod.GET)
	public List<Dept> list() ;
	
	@RequestMapping(value = "/dept/client",method=RequestMethod.GET)
	public Object client();
}
