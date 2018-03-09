package com.blogforum.manager.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.AdminUser;
import com.blogforum.manager.pojo.entity.Role;
import com.blogforum.manager.pojo.page.Page;
import com.blogforum.manager.service.dao.RoleService;
import com.blogforum.notebook.common.enums.IsDelFlagEnum;

@Controller
@RequestMapping("role")
public class RoleController {
	

	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("queryList.action")
	@ResponseBody
	public blogforumResult queryList(Integer pageSize,Integer pageNo){
		Page<Role> roles = roleService.queryListPage(pageSize, pageNo);
		return blogforumResult.ok(roles);
	}
	
	
	@RequestMapping("get.action")
	@ResponseBody
	public blogforumResult get(Integer id){
		Role role = roleService.getByID(id);
		return blogforumResult.ok(role);
	}
	
	@RequestMapping(value = "add.action" , method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult add(HttpServletRequest request, Role role){
		Role role2 = roleService.get(role);
		if (role2 != null) {
			return blogforumResult.build("201", "角色已经存在", "true");
		}
		HttpSession session = request.getSession();
		AdminUser adminUser = (AdminUser) session.getAttribute("adminuser");
		role.setDelFlag(IsDelFlagEnum.N.getValue());
		role.setCreateUser(adminUser.getUsername());
		roleService.save(role);
		return blogforumResult.ok();
	}
	
	@RequestMapping(value = "edit.action", method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult edit(HttpServletRequest request,Role role){
		
		Role newRole = roleService.getByID(role.getId());
		newRole.setName(role.getName());
		newRole.setDelFlag(role.getDelFlag());
		newRole.setRemarks(role.getRemarks());
		roleService.update(newRole);
		return blogforumResult.ok();
	}
	
	
	@RequestMapping(value = "del.action", method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult del(Integer id){
		
		Role role = roleService.getByID(id);
		role.setDelFlag(IsDelFlagEnum.Y.getValue());
		roleService.update(role);
		return blogforumResult.ok();
	}


}
