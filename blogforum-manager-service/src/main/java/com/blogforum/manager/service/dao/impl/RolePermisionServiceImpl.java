package com.blogforum.manager.service.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.manager.dao.mapper.RolePermisionMapper;
import com.blogforum.manager.pojo.entity.RolePermision;
import com.blogforum.manager.service.dao.CrudService;
import com.blogforum.manager.service.dao.RolePermisionService;

@Service
public class RolePermisionServiceImpl extends CrudService<RolePermision> implements RolePermisionService {

	@Autowired
	private RolePermisionMapper rolePermisionMapper;
	
	
	@Override
	public List<RolePermision> queryListByRoleId(RolePermision rolePermision) {
		return rolePermisionMapper.queryListByRoleId(rolePermision);
	}

	@Override
	public List<RolePermision> queryListByPermisionId(RolePermision rolePermision) {
		
		return rolePermisionMapper.queryListByPermisionId(rolePermision);
	}

}
