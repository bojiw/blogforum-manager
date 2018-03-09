package com.blogforum.manager.service.manager;

import com.blogforum.manager.pojo.vo.UserAllCountVO;

public interface UserManager {
	
	/**
	 * 获取后台首页用户总数相关信息
	 * @return
	 * @author: wwd
	 * @time: 2018年3月4日
	 */
	UserAllCountVO getUserCount();

}
