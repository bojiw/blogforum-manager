package com.blogforum.manager.dao.mapper;

import java.util.List;

import com.blogforum.manager.pojo.entity.RolePermision;

/**
 * 角色权限关联表
 * 
 * @author wwd
 *
 */
public interface RolePermisionMapper extends CrudMapper<RolePermision> {
	
	
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
