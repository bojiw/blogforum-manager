package com.blogforum.manager.service.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogforum.common.tools.BaseConverter;
import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.Permision;
import com.blogforum.manager.pojo.entity.Role;
import com.blogforum.manager.pojo.entity.RolePermision;
import com.blogforum.manager.pojo.page.Page;
import com.blogforum.manager.pojo.vo.RolePermisionVO;
import com.blogforum.manager.service.dao.PermisionService;
import com.blogforum.manager.service.dao.RolePermisionService;
import com.blogforum.manager.service.dao.RoleService;
import com.blogforum.manager.service.manager.RolePermisionManager;
import com.google.common.collect.Lists;

@Component
public class RolePermisionManagerImpl implements RolePermisionManager {

	@Autowired
	private RolePermisionService rolePermisionService;
	
	@Autowired
	private RoleService				roleService;

	@Autowired
	private PermisionService		permisionService;

	@Override
	public void addRolePermision(RolePermision rolePermision) {
		rolePermisionService.save(rolePermision);
		
	}

	@Override
	public void delRolePermision(RolePermision rolePermision) {
		rolePermisionService.delete(rolePermision);
	}

	@Override
	public blogforumResult queryAllPage(Integer pageSize, Integer pageNo) {
		RolePermision t = new RolePermision();
		Page<RolePermision> queryList = rolePermisionService.queryList(new Page<RolePermision>(pageNo, pageSize), t);
		BaseConverter<Page<RolePermision>, Page> baseConverter = new BaseConverter<>();
		Page convert = baseConverter.convert(queryList, Page.class);
		List<RolePermisionVO> newRolePermisionVOs = newRolePermisionVOs(queryList.getList());
		convert.setList(newRolePermisionVOs);
		return blogforumResult.ok(convert);
	}
	
	private List<RolePermisionVO> newRolePermisionVOs(List<RolePermision> rolePermisions){
		List<RolePermisionVO> list = Lists.newArrayList();
		for (RolePermision rolePermision : rolePermisions) {
			Role role = roleService.get(new Role(rolePermision.getRoleId()));
			Permision permision = permisionService.get(new Permision(rolePermision.getPermisionId()));
			RolePermisionVO permisionVO = new RolePermisionVO(rolePermision.getId(), role, permision);
			list.add(permisionVO);
		}
		return list;
	}
	

	@Override
	public blogforumResult search(Integer pageSize, Integer pageNo, String type, String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
