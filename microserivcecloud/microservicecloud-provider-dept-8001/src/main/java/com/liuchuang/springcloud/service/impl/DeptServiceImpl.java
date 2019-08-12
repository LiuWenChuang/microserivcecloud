package com.liuchuang.springcloud.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuchuang.springcloud.dao.DeptDao;
import com.liuchuang.springcloud.entities.Dept;
import com.liuchuang.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	  
	@Autowired
	private DeptDao deptDao;

	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		// TODO Auto-generated method stub
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return deptDao.findAll();
	}

}
