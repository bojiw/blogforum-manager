package com.blogforum.manager.service.user;

import java.util.Date;

import com.blogforum.manager.pojo.page.Page;
import com.blogforum.manager.pojo.vo.User;
import com.blogforum.sso.facade.enums.UserStatusEnum;

public interface UserServer {

	

	
	/**
	 * 根据userId获取用户
	 * @param token
	 * @return
	 * @author: wwd
	 * @time: 2017年11月4日
	 */
	User  getUserByUserId (String userId);
	
	

	/**
	 * 分页获取用户 status传空代表获取所有状态用户
	 * @param request
	 * @return
	 * @author: wwd
	 * @time: 2018年3月3日
	 */
	Page<User> queryAllUserPage(Integer pageNo,Integer pageSize,UserStatusEnum status,String keyword);
	
	

	/**
	 * 获取对应状态用户总数或者所有用户总数
	 * @param delFlag 如果为空获取所有状态用户总数
	 * @return
	 * @author: wwd
	 * @time: 2018年3月3日
	 */
	Integer getAllUserCount(UserStatusEnum status);
	
	
	/**
	 * 获取指定时间段的用户数
	 * @param staterDate 开始时间
	 * @param endDate 结束时间
	 * @param delFlag 如果为空获取所有在线和删除用户总数
	 * @return
	 * @author: wwd
	 * @time: 2018年3月3日
	 */
	Integer getDateInUser(Date startDate,Date endDate,UserStatusEnum status);
	
	

	/**
	 * 更新用户密码
	 * 
	 * @author: wwd
	 * @time: 2018年3月24日
	 */
	void updateUserPwd(String id,String newPassword, String updateUser);
	

	/**
	 * 更新用户状态
	 * @param id
	 * @param status
	 * @param updateUser
	 * @author: wwd
	 * @time: 2018年3月24日
	 */
	void updateUserStatus(String id,Integer status,String updateUser);


}
