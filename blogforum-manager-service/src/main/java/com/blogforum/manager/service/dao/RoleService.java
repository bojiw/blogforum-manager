package com.blogforum.manager.service.dao;

import java.util.List;

import com.blogforum.manager.pojo.entity.Role;
import com.blogforum.manager.pojo.page.Page;

public interface RoleService extends BaseService<Role>{


	/**
	 * 通过ID查询角色
	 * 
	 * @param role_id
	 * @return
	 * @author wwd
	 * @date 2017年3月10日下午11:53:45
	 * @version V1.0
	 */
	Role getByID(int role_id);
	
	/**
	 * 更新角色信息
	 * @param role
	 * @return
	 * @author wwd
	 * @date 2017年3月13日下午10:39:21
	 * @version V1.0
	 */
	void updateRole(Role role);
	
	/**
	 * 分页查询角色
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @author: wwd
	 * @time: 2018年3月6日
	 */
	Page<Role> queryListPage(Integer pageSize, Integer pageNo);

}
