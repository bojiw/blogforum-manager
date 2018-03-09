package com.blogforum.manager.dao.mapper;

import com.blogforum.manager.pojo.entity.AdminUser;

/**
 * 操作管理员用户表
 * 
 * @author wwd
 *
 */
public interface AdminUserMapper {
	/**
	 * 插入管理员用户
	 * 
	 * @param adminUser
	 * @author wwd
	 * @date 2017年2月25日下午2:50:27
	 * @version V1.0
	 */
	public int insert(AdminUser adminUser);

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
	public AdminUser getByID(String adminUser_id);

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
