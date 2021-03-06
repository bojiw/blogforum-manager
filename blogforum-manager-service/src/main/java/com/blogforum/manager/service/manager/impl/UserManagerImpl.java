package com.blogforum.manager.service.manager.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.blogforum.common.tools.DateUtils;
import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.page.Page;
import com.blogforum.manager.pojo.vo.CountVO;
import com.blogforum.manager.pojo.vo.User;
import com.blogforum.manager.pojo.vo.UserAllCountVO;
import com.blogforum.manager.service.manager.UserManager;
import com.blogforum.manager.service.user.UserServer;
import com.blogforum.sso.facade.enums.UserStatusEnum;

@Component
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserServer userServer;
	
	/**
	 * 用户默认密码
	 */
	@Value("${user.defaultpwd}")
	private String defaultPassword;

	@Override
	public UserAllCountVO getUserCount() {
		
		//获取所有注册用户总数
		CountVO allUserCountVO = getStatusCount(null, "历史注册用户总数");
		//获取正常状态用户总数
		CountVO activeUserCount = getStatusCount(UserStatusEnum.ACTIVE, "正常状态用户总数");
		//最近一个月注册用户总数
		CountVO lastMonthUserCount = getDateCount(DateUtils.getLastMonthDate(), "最近一个月注册用户总数");
		//最近七天注册用户总数
		CountVO lastSevenUserCount = getDateCount(DateUtils.getLastSevenDate(), "最近七天注册用户总数");
		UserAllCountVO countVO = new UserAllCountVO();
		countVO.setAllUserCount(allUserCountVO);
		countVO.setActiveUserCount(activeUserCount);
		countVO.setLastMonthUserCount(lastMonthUserCount);
		countVO.setLastSevenUserCount(lastSevenUserCount);
		
		return countVO;
	}
	
	/**
	 * 获取时间相关的用户总数
	 * @param startDate
	 * @param memo
	 * @return
	 * @author: wwd
	 * @time: 2018年3月4日
	 */
	private CountVO getDateCount(Date startDate, String memo){
		Integer MonthCount = userServer.getDateInUser(startDate, new Date(), UserStatusEnum.ACTIVE);
		CountVO dateUserCount = new CountVO();
		dateUserCount.setCount(MonthCount);
		dateUserCount.setMemo(memo);
		return dateUserCount;
	}
	
	/**
	 * 获取状态相关的用户总数
	 * @param statusEnum
	 * @param memo
	 * @return
	 * @author: wwd
	 * @time: 2018年3月4日
	 */
	private CountVO getStatusCount(UserStatusEnum statusEnum,String memo){
		Integer allUserCount = userServer.getAllUserCount(statusEnum);
		CountVO allUserCountVO = new CountVO();
		allUserCountVO.setCount(allUserCount);
		allUserCountVO.setMemo(memo);
		return allUserCountVO;
	}

	@Override
	public blogforumResult queryAllStatusUserPage(Integer pageNo, Integer pageSize,String keyword) {
		
		Page<User> userPage = userServer.queryAllUserPage(pageNo, pageSize, null,keyword);
		
		return blogforumResult.ok(userPage);
	}

	@Override
	public blogforumResult getUser(String id) {
		User user = userServer.getUserByUserId(id);
		return blogforumResult.ok(user);
	}

	@Override
	public blogforumResult updateDefaultPwd(String id, String updateUser) {
		userServer.updateUserPwd(id, defaultPassword, updateUser);
		return blogforumResult.ok();
	}

	@Override
	public blogforumResult updateUserStatus(String id, Integer status, String updateUser) {
		userServer.updateUserStatus(id, status, updateUser);
		return blogforumResult.ok();
	}
	

	

}
