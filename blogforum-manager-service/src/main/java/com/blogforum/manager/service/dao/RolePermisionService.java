package com.blogforum.manager.service.dao;

import java.util.List;

import com.blogforum.manager.pojo.entity.RolePermision;

/**
 * 角色权限关联服务
 * @author wwd
 *
 */
public interface RolePermisionService extends BaseService<RolePermision> {

	
	/**
	 * 通过角色id查询关联信息
	 * @param rolePermision
	 * @return
	 * @author: wwd
	 * @time: 2018年3月11日
	 */
	List<RolePermision> queryListByRoleId(RolePermision rolePermision);
	
	
	/**
	 * 通过权限id查询关联信息
	 * @param rolePermision
	 * @return
	 * @author: wwd
	 * @time: 2018年3月11日
	 */
	List<RolePermision> queryListByPermisionId(RolePermision rolePermision);
	
}
