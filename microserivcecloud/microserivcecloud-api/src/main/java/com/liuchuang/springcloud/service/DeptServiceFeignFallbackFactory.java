package com.liuchuang.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.liuchuang.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component  // 将 服务降级 注入spring容器中
public class DeptServiceFeignFallbackFactory implements FallbackFactory<DeptServiceFeign> {

	@Override
	public DeptServiceFeign create(Throwable arg0) {
		
		return new DeptServiceFeign() {
		
			@Override
			public List<Dept> list() {
				System.out.println("此服务降级：访问的访问为list");
				return null;
			}
			
			@Override
			public Dept get(Long id) {
				System.out.println("此服务降级：访问的访问为get  id为："+id);
				return new Dept();
			}
			
			@Override
			public Object client() {
				System.out.println("此服务降级：访问的访问为client");
				return new Object();
			}
			
			@Override
			public boolean add(Dept dept) {
				System.out.println("此服务降级：访问的访问为add");
				return false;
			}
		};
	}

}
