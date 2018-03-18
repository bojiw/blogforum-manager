package com.blogforum.manager.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.vo.UserAllCountVO;
import com.blogforum.manager.service.manager.UserManager;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserManager userManager;

	
	@RequestMapping("/getCount.action")
	@ResponseBody
	public blogforumResult getCount() {
		UserAllCountVO userCount = userManager.getUserCount();
		return blogforumResult.ok(userCount);
	}
	
	@RequestMapping("/queryList.action")
	@ResponseBody
	public blogforumResult queryList(Integer pageSize,Integer pageNo,String keyword) {
		blogforumResult page = userManager.queryAllStatusUserPage(pageNo, pageSize, keyword);
		return blogforumResult.ok(page);
	}
	
	
	@RequestMapping("/get.action")
	@ResponseBody
	public blogforumResult get(Integer pageSize,Integer pageNo,String keyword) {
		blogforumResult page = userManager.queryAllStatusUserPage(pageNo, pageSize, keyword);
		return blogforumResult.ok(page);
	}
	
	

}
