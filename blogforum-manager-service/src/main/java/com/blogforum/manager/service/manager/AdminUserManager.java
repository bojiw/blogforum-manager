package com.blogforum.manager.service.manager;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.AdminUser;

/**
 * 对管理员用户的操作接口
 * 
 * @author wwd
 *
 */
public interface AdminUserManager {
	/**
	 * 创建管理员用户
	 * 
	 * @param adminUser
	 * @author wwd
	 * @date 2017年2月25日下午2:58:53
	 * @version V1.0
	 */
	blogforumResult insert(AdminUser adminUser);
	
	

	
	/**
	 * 通过用户名密码查询用户
	 * 
	 * @param adminUser
	 * @return
	 * @author wwd
	 * @date 2017年3月10日下午9:31:22
	 * @version V1.0
	 */
	AdminUser getByUserPwd(AdminUser adminUser);

	
	/**
	 * 通过ID查询用户
	 * 
	 * @param adminUser_id
	 * @return AdminUser
	 * @author wwd
	 * @date 2017年3月10日下午9:31:22
	 * @version V1.0
	 */
	AdminUser getByID(Integer adminUserId);

	/**
	 * 通过用户名查询用户
	 * 
	 * @param username
	 * @return AdminUser
	 * @author wwd
	 * @date 2017年3月10日下午9:31:22
	 * @version V1.0
	 */
	AdminUser getByUserName(String username);
	
	/**
	 * 更新用户
	 * @param adminUser
	 * @author: wwd
	 * @time: 2018年3月13日
	 */
	void update(AdminUser adminUser);
	
	/**
	 * 分页查询用户列表
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @author: wwd
	 * @time: 2018年3月13日
	 */
	blogforumResult queryListPage(Integer pageSize,Integer pageNo);
	
	
	/**
	 * 删除后台用户
	 * @param id
	 * @author: wwd
	 * @time: 2018年3月13日
	 */
	void delete(Integer id);
}
