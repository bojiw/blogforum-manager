package com.blogforum.manager.integration.user.impl;

import java.util.Date;

import com.blogforum.common.model.Result;
import com.blogforum.common.tools.rpc.BaseInvocation;
import com.blogforum.common.tools.rpc.ServiceTemplate;
import com.blogforum.manager.integration.user.UserServerFacadeClient;
import com.blogforum.sso.facade.enums.UserStatusEnum;
import com.blogforum.sso.facade.model.SsoPage;
import com.blogforum.sso.facade.model.SsoUpdateUserPwd;
import com.blogforum.sso.facade.model.SsoUpdateUserStatus;
import com.blogforum.sso.facade.model.SsoUserPageRequest;
import com.blogforum.sso.facade.model.UserVO;
import com.blogforum.sso.facade.user.UserServerFacade;

public class UserServerFacadeClientImpl implements UserServerFacadeClient {

	private UserServerFacade userServerFacade;
	
	@Override
	public UserVO getUserByUserId(final String userId) {
		
		return ServiceTemplate.invoke(new BaseInvocation<UserVO>() {

			@Override
			public Result<UserVO> execute() {
				return userServerFacade.getUserByUserId(userId);
			}
		});
		
	}

	@Override
	public SsoPage<UserVO> queryAllUserPage(final SsoUserPageRequest request) {
		return ServiceTemplate.invoke(new BaseInvocation<SsoPage<UserVO>>() {

			@Override
			public Result<SsoPage<UserVO>> execute() {
				return userServerFacade.querySearchAllUserPage(request);
			}
		});
		
	}

	@Override
	public Integer getAllUserCount(final UserStatusEnum status) {
		return ServiceTemplate.invoke(new BaseInvocation<Integer>() {

			@Override
			public Result<Integer> execute() {
				return userServerFacade.getAllUserCount(status);
			}
		});
	}

	@Override
	public Integer getDateInUser(final Date startDate, final Date endDate,final UserStatusEnum status) {
		return ServiceTemplate.invoke(new BaseInvocation<Integer>() {

			@Override
			public Result<Integer> execute() {
				return userServerFacade.getDateInUser(startDate, endDate, status);
			}
		});
	}
	
	
	@Override
	public Boolean updateUserPwd(final SsoUpdateUserPwd updatePwd) {
		return ServiceTemplate.invoke(new BaseInvocation<Boolean>() {

			@Override
			public Result<Boolean> execute() {
				return userServerFacade.updateUserPwd(updatePwd);
			}
		});
	}

	@Override
	public Boolean updateUserStatus(final SsoUpdateUserStatus updateStatus) {
		return ServiceTemplate.invoke(new BaseInvocation<Boolean>() {

			@Override
			public Result<Boolean> execute() {
				return userServerFacade.updateUserStatus(updateStatus);
			}
		});
	}

	public void setUserServerFacade(UserServerFacade userServerFacade) {
		this.userServerFacade = userServerFacade;
	}


	

}

	
