package com.blogforum.manager.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.AdminUser;
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
	public blogforumResult queryList(@RequestParam(defaultValue = "10") Integer pageSize,@RequestParam(defaultValue = "1")Integer pageNo,String keyword) {
		blogforumResult page = userManager.queryAllStatusUserPage(pageNo, pageSize, keyword);
		return blogforumResult.ok(page);
	}
	
	
	@RequestMapping("/get.action")
	@ResponseBody
	public blogforumResult get(String id) {
		blogforumResult user = userManager.getUser(id);
		return blogforumResult.ok(user);
	}
	
	@RequestMapping(value = "/updateDefaultPwd.action",method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult updateDefaultPwd(String id,HttpSession session ) {
		AdminUser adminUser = (AdminUser) session.getAttribute("adminuser");
		blogforumResult result = userManager.updateDefaultPwd(id, adminUser.getUsername());
		return result;
	}
	
	
	@RequestMapping(value = "/updateStatus.action",method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult updateStatus(String id,Integer status,HttpSession session){
		AdminUser adminUser = (AdminUser) session.getAttribute("adminuser");
		blogforumResult result = userManager.updateUserStatus(id, status, adminUser.getUsername());
		return result;
	}
	

}
