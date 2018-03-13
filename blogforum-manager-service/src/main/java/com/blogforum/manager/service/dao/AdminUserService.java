package com.blogforum.manager.service.dao;

import com.blogforum.manager.pojo.entity.AdminUser;

public interface AdminUserService extends BaseService<AdminUser> {

	
	/**
	 * 通过用户名密码查询用户
	 * 
	 * @param adminUser
	 * @return
	 * @author wwd
	 * @date 2017年3月10日下午9:31:22
	 * @version V1.0
	 */
	public AdminUser getByUserPwd(AdminUser adminUser);

	/**
	 * 通过ID查询用户
	 * 
	 * @param adminUser_id
	 * @return
	 * @author wwd
	 * @date 2017年3月10日下午9:31:22
	 * @version V1.0
	 */
	public AdminUser getByID(Integer adminUserId);

	/**
	 * 通过用户名查询用户
	 * 
	 * @param username
	 * @return
	 * @author wwd
	 * @date 2017年3月10日下午9:31:22
	 * @version V1.0
	 */
	public AdminUser getByUserName(String username);

}
