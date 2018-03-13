package com.blogforum.manager.service.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.manager.dao.mapper.RoleMapper;
import com.blogforum.manager.pojo.entity.Role;
import com.blogforum.manager.pojo.page.Page;
import com.blogforum.manager.service.dao.CrudService;
import com.blogforum.manager.service.dao.RoleService;

@Service
public class RoleServiceImpl extends CrudService<Role> implements RoleService {
	
	private static Logger	logger	= Logger.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleMapper roleMapper;



	//设置ehcache缓存 根据roleid
	@Override
	//@Cacheable(value="baseCache",key="'Role'+#role_id")
	public Role getByID(int role_id) {
		Role role = null;
		try {
			role = roleMapper.getByID(role_id);
		} catch (Exception e) {
			logger.error(BizErrorEnum.DATABASE_EXCEPTION.getMsg(),e);
			return role;
		}
		return role;
	}

	//删除ehcache缓存 根据roleid
	@Override
	//@CacheEvict(value="baseCache",key="'Role'+#role.getId()")
	public void updateRole(Role role) {
		roleMapper.update(role);
	}

	@Override
	public Page<Role> queryListPage(Integer pageSize, Integer pageNo) {
		
		Role role = new Role();
		Page<Role> page = new Page<>(pageNo, pageSize);
		Page<Role> queryList = super.queryList(page, role);
		return queryList;
	}

}
