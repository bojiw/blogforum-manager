package com.blogforum.manager.integration.user;

import java.util.Date;

import com.blogforum.sso.facade.enums.UserStatusEnum;
import com.blogforum.sso.facade.model.SsoPage;
import com.blogforum.sso.facade.model.SsoUpdateUserPwd;
import com.blogforum.sso.facade.model.SsoUpdateUserStatus;
import com.blogforum.sso.facade.model.SsoUserPageRequest;
import com.blogforum.sso.facade.model.UserVO;

public interface UserServerFacadeClient {
	

	
	/**
	 * 根据userId获取用户
	 * @param token
	 * @return
	 * @author: wwd
	 * @time: 2017年11月4日
	 */
	UserVO  getUserByUserId (String userId);
	
	

	/**
	 * 分页获取用户
	 * @param request
	 * @return
	 * @author: wwd
	 * @time: 2018年3月3日
	 */
	SsoPage<UserVO> queryAllUserPage(SsoUserPageRequest request);
	
	

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
	 * @param updatePwd
	 * @return
	 * @author: wwd
	 * @time: 2018年3月24日
	 */
	Boolean updateUserPwd(SsoUpdateUserPwd updatePwd);

	/**
	 * 更新用户状态
	 * @param updateStatus
	 * @return
	 * @author: wwd
	 * @time: 2018年3月24日
	 */
	Boolean updateUserStatus(SsoUpdateUserStatus updateStatus);

}
