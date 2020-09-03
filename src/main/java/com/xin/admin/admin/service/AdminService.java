package com.xin.admin.admin.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xin.entity.Admin;

import com.xin.mapper.AdminMapper;

@Service
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	public Admin login(Admin admin) {

		return adminMapper.selectAdminByLoginnameAndLoginpass(admin);
	}

	
}
