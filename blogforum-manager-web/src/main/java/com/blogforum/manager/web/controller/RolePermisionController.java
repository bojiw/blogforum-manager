package com.blogforum.manager.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.RolePermision;
import com.blogforum.manager.service.manager.RolePermisionManager;

@Controller
@RequestMapping("/rolepermision")
public class RolePermisionController {
	
	@Autowired
	private RolePermisionManager rolePermisionManager;
	
	
	@RequestMapping("/queryList.action")
	@ResponseBody
	public blogforumResult queryList(int pageSize,int pageNo){
		
		blogforumResult queryAllPage = rolePermisionManager.queryAllPage(pageSize, pageNo);
		return queryAllPage;
		
	}
	
	
	@RequestMapping("/del.action")
	@ResponseBody
	public blogforumResult del(int id){
		
		rolePermisionManager.delRolePermision(new RolePermision(id));
		return blogforumResult.ok();
		
	}

}
