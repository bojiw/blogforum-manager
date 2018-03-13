package com.blogforum.manager.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.common.exception.BusinessException;
import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.AdminUser;
import com.blogforum.manager.service.manager.AdminUserManager;

/**
 * 对管理员的操作Controller
 * 
 * @author wwd
 *
 */
@Controller
@RequestMapping("/adminuser")
public class AdminUserController {

	@Autowired
	private AdminUserManager	adminUserManager;

	@RequestMapping(value = "/add.action", method = { RequestMethod.POST })
	@ResponseBody
	public blogforumResult insert(String username, String password, Integer roleId, HttpSession session)
						throws BusinessException {

		AdminUser loginAdmin = (AdminUser) session.getAttribute("adminuser");
		AdminUser adminUser = checkInsert(username, password, roleId);
		adminUser.setCreateUser(loginAdmin.getUsername());
		blogforumResult result = adminUserManager.insert(adminUser);
		return result;
	}
	

	@RequestMapping(value = "/edit.action", method = { RequestMethod.POST })
	@ResponseBody
	public blogforumResult update(AdminUser adminUser, HttpSession session)
						throws BusinessException {

		adminUserManager.update(adminUser);
		return blogforumResult.ok();
	}
	
	@RequestMapping(value = "/queryList.action", method = { RequestMethod.GET })
	@ResponseBody
	public blogforumResult queryList(Integer pageNo, Integer pageSize){

		blogforumResult adminUserList = adminUserManager.queryListPage(pageSize, pageNo);
		return blogforumResult.ok(adminUserList);
	}
	
	@RequestMapping(value = "/del.action", method = { RequestMethod.POST })
	@ResponseBody
	public blogforumResult del(Integer id){
		adminUserManager.delete(id);
		return blogforumResult.ok();
	}
	
	
	
	@RequestMapping(value = "/get.action", method = { RequestMethod.GET })
	@ResponseBody
	public blogforumResult get(Integer id){
		AdminUser adminUser = adminUserManager.getByID(id);
		return blogforumResult.ok(adminUser);
	}

	/**
	 * 验证添加的管理员参数是否正确
	 * 
	 * @param username
	 * @param password
	 * @param roleId
	 * @return
	 * @author wwd
	 * @date 2017年3月4日下午11:35:23
	 * @version V1.0
	 */
	private AdminUser checkInsert(String username, String password, Integer roleId) {
		if (StringUtils.isBlank(username) && StringUtils.isBlank(password) && roleId == null) {
			throw new BusinessException(BizErrorEnum.NULL_PARAMETER);
		}

		AdminUser adminUser = new AdminUser();
		adminUser.setUsername(username);
		adminUser.setPassword(password);
		adminUser.setRoleId(roleId);
		return adminUser;
	}



}
