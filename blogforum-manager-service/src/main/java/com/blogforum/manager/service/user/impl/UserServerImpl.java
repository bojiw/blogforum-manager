package com.blogforum.manager.service.user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogforum.manager.integration.user.UserServerFacadeClient;
import com.blogforum.manager.service.user.UserServer;
import com.blogforum.sso.facade.enums.UserStatusEnum;
import com.blogforum.sso.facade.model.SsoPage;
import com.blogforum.sso.facade.model.SsoUserPageRequest;
import com.blogforum.sso.facade.model.UserVO;

@Component
public class UserServerImpl implements UserServer {
	
	@Autowired
	private UserServerFacadeClient userServerFacadeClient;

	@Override
	public UserVO getUserByUserId(String userId) {
		return userServerFacadeClient.getUserByUserId(userId);
	}

	@Override
	public SsoPage<UserVO> queryAllUserPage(SsoUserPageRequest request) {
		return userServerFacadeClient.queryAllUserPage(request);
	}

	@Override
	public Integer getAllUserCount(UserStatusEnum status) {
		return userServerFacadeClient.getAllUserCount(status);
	}

	@Override
	public Integer getDateInUser(Date startDate, Date endDate, UserStatusEnum status) {
		return userServerFacadeClient.getDateInUser(startDate, endDate, status);
	}

}
