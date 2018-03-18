package com.blogforum.manager.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogforum.manager.integration.user.UserServerFacadeClient;
import com.blogforum.manager.pojo.page.Page;
import com.blogforum.manager.pojo.vo.User;
import com.blogforum.manager.service.user.UserServer;
import com.blogforum.sso.facade.enums.RoleEnum;
import com.blogforum.sso.facade.enums.UserStatusEnum;
import com.blogforum.sso.facade.model.SsoPage;
import com.blogforum.sso.facade.model.SsoUserPageRequest;
import com.blogforum.sso.facade.model.UserVO;
import com.google.common.collect.Lists;

@Component
public class UserServerImpl implements UserServer {
	
	@Autowired
	private UserServerFacadeClient userServerFacadeClient;

	@Override
	public UserVO getUserByUserId(String userId) {
		return userServerFacadeClient.getUserByUserId(userId);
	}

	@Override
	public Page<User> queryAllUserPage(Integer pageNo,Integer pageSize,UserStatusEnum status,String keyword) {
		SsoUserPageRequest request = new SsoUserPageRequest(pageNo, pageSize);
		request.setStatus(status);
		request.setKeyword(keyword);
		SsoPage<UserVO> queryAllUserPage = userServerFacadeClient.queryAllUserPage(request);
		Page<User> page = new Page<>(queryAllUserPage.getPageNo(), queryAllUserPage.getPageSize());
		page.setCount(queryAllUserPage.getCount());
		List<UserVO> userVOs = queryAllUserPage.getList();
		List<User> users = Lists.newArrayList();
		for (UserVO userVO : userVOs) {
			users.add(buildUser(userVO));
		}
		page.setList(users);
		return page;
	}
	
	private User buildUser(UserVO userVO){
		User user = new User();
		user.setId(userVO.getId());
		user.setUsername(userVO.getUsername());
		user.setRole(userVO.getRole());
		user.setRoleCN(RoleEnum.getChinesByValue(userVO.getRole()));
		user.setEmail(userVO.getEmail());
		user.setIphone(userVO.getIphone());
		user.setLoginDate(userVO.getLoginDate());
		user.setLoginIp(userVO.getLoginIp());
		user.setStatus(userVO.getStatus());
		user.setStatusCN(UserStatusEnum.getChineseByValue(userVO.getStatus()));
		user.setImage(userVO.getImage());
		user.setRemarks(userVO.getRemarks());
		user.setBirthCity(userVO.getBirthCity());
		user.setBirthProvince(userVO.getBirthProvince());
		user.setCityLocation(userVO.getCityLocation());
		user.setProvinceLocation(userVO.getProvinceLocation());
		return user;
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
