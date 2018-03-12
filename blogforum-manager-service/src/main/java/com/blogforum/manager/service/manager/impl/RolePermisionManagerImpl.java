package com.blogforum.manager.service.manager.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.blogforum.common.exception.BusinessException;
import com.blogforum.common.tools.BaseConverter;
import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.common.enums.RolePermisionSearchEnum;
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
		Role role = roleService.get(new Role(rolePermision.getRoleId()));
		if (role == null) {
			throw new BusinessException("未搜索到该角色");
		}
		Permision permision = permisionService.get(new Permision(rolePermision.getPermisionId()));
		if (permision == null) {
			throw new BusinessException("未搜索到该权限名");
		}
		List<RolePermision> queryList = rolePermisionService.queryList(new RolePermision(null, rolePermision.getRoleId(), rolePermision.getPermisionId()));
		if (CollectionUtils.isNotEmpty(queryList)) {
			throw new BusinessException("该角色和权限以关联");
		}
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
		Page newPage = newRolePermisionVOs(queryList);
		return blogforumResult.ok(newPage);
	}
	
	private Page newRolePermisionVOs(Page<RolePermision> queryList){
		BaseConverter<Page<RolePermision>, Page> baseConverter = new BaseConverter<>();
		Page convert = baseConverter.convert(queryList, Page.class);
		List<RolePermisionVO> newRolePermisionVOs = Lists.newArrayList();
		for (RolePermision rolePermision : queryList.getList()) {
			Role role = roleService.get(new Role(rolePermision.getRoleId()));
			Permision permision = permisionService.get(new Permision(rolePermision.getPermisionId()));
			RolePermisionVO permisionVO = new RolePermisionVO(rolePermision.getId(), role, permision);
			newRolePermisionVOs.add(permisionVO);
		}
		convert.setList(newRolePermisionVOs);
		return convert;
	}
	

	@Override
	public blogforumResult search(Integer pageSize, Integer pageNo, String type, Integer id) {
		
		Page<RolePermision> page = null;
		RolePermision query = null;
		if (StringUtils.equals(type, RolePermisionSearchEnum.ROLE.getType())) {
			query = new RolePermision(null,id,null);
		}else {
			query = new RolePermision(null,null,id);
			
		}
		page = rolePermisionService.queryList(new Page<RolePermision>(pageNo, pageSize), query);
		Page newRolePermisionVOs = newRolePermisionVOs(page);
		
		return blogforumResult.ok(newRolePermisionVOs);
	}
	
	

}
