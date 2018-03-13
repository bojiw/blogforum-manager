package com.blogforum.manager.service.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.manager.dao.mapper.AdminUserMapper;
import com.blogforum.manager.pojo.entity.AdminUser;
import com.blogforum.manager.service.dao.AdminUserService;
import com.blogforum.manager.service.dao.CrudService;

@Service
public class AdminUserServiceImpl extends CrudService<AdminUser> implements AdminUserService  {

	@Autowired
	private AdminUserMapper adminUserMapper;
	
	@Override
	public AdminUser getByID(Integer adminUserId) {
		return adminUserMapper.getByID(adminUserId);
	}

	@Override
	public AdminUser getByUserPwd(AdminUser adminUser) {
		return adminUserMapper.getByUserPwd(adminUser);
	}

	@Override
	public AdminUser getByUserName(String username) {
		return adminUserMapper.getByUserName(username);
	}
	
	
	
}
