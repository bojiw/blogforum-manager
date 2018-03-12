package com.blogforum.manager.service.manager;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.RolePermision;

/**
 * 角色权限关联管理
 * @author wwd
 *
 */
public interface RolePermisionManager {

	/**
	 * 新增关联
	 * @param rolePermision
	 * @author: wwd
	 * @time: 2018年3月11日
	 */
	void addRolePermision(RolePermision rolePermision);
	
	
	/**
	 * 删除关联
	 * @param rolePermision
	 * @author: wwd
	 * @time: 2018年3月11日
	 */
	void delRolePermision(RolePermision rolePermision);
	
	
	/**
	 * 分页查询数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @author: wwd
	 * @time: 2018年3月11日
	 */
	blogforumResult queryAllPage(Integer pageSize,Integer pageNo);
	
	
	/**
	 * 通过角色id或者权限id搜索
	 * @param pageSize
	 * @param pageNo
	 * @param type
	 * @param id
	 * @return
	 * @author: wwd
	 * @time: 2018年3月11日
	 */
	blogforumResult search(Integer pageSize,Integer pageNo,String type,Integer id);
	
	
	
	
	
	
}
