package com.blogforum.manager.dao.mapper;

import com.blogforum.manager.pojo.entity.Role;

/**
 * 操作管理员用户表
 * 
 * @author wwd
 *
 */
public interface RoleMapper extends CrudMapper<Role> {



	/**
	 * 通过ID查询角色
	 * 
	 * @param role_id
	 * @return
	 * @author wwd
	 * @date 2017年3月10日下午11:53:45
	 * @version V1.0
	 */
	public Role getByID(int role_id);

}
