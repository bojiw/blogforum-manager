package com.blogforum.manager.service.manager;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.vo.UserAllCountVO;

public interface UserManager {
	
	/**
	 * 获取后台首页用户总数相关信息
	 * @return
	 * @author: wwd
	 * @time: 2018年3月4日
	 */
	UserAllCountVO getUserCount();
	
	/**
	 * 分页查询所有状态用户
	 * @param pageNo
	 * @param pageSize
	 * @param status
	 * @return
	 * @author: wwd
	 * @time: 2018年3月14日
	 */
	blogforumResult queryAllStatusUserPage(Integer pageNo,Integer pageSize,String keyword);
	
	/**
	 * 获取用户
	 * @param id
	 * @return
	 * @author: wwd
	 * @time: 2018年3月16日
	 */
	blogforumResult getUser(String id);

	
	
}
