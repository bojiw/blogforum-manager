package com.blogforum.manager.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.Permision;
import com.blogforum.manager.service.dao.PermisionService;

@Controller
@RequestMapping("/permision")
public class PermisionController {
	
	@Autowired
	private PermisionService permisionService;
	
	
	@RequestMapping("queryList.action")
	@ResponseBody
	public blogforumResult queryList(Integer pageSize,Integer pageNo){
		blogforumResult queryListPage = permisionService.queryListPage(pageSize, pageNo);
		return queryListPage;
	}
	
	
	@RequestMapping("get.action")
	@ResponseBody
	public blogforumResult get(Permision permision){
		Permision permision2 = permisionService.get(permision);
		return blogforumResult.ok(permision2);
	}
	
	@RequestMapping(value = "add.action" , method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult add(Permision permision){
		permisionService.save(permision);
		return blogforumResult.ok();
	}
	
	@RequestMapping(value = "edit.action", method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult edit(Permision permision){
		permisionService.update(permision);
		return blogforumResult.ok();
	}
	
	@RequestMapping(value = "del.action", method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult del(Permision permision){
		permisionService.delete(permision);
		return blogforumResult.ok();
	}
}
