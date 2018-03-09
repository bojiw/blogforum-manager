package com.blogforum.manager.service.dao.impl;

import org.springframework.stereotype.Component;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.Permision;
import com.blogforum.manager.pojo.page.Page;
import com.blogforum.manager.service.dao.CrudService;
import com.blogforum.manager.service.dao.PermisionService;

@Component
public class PermisionServiceImpl extends CrudService<Permision> implements PermisionService  {
	
	
	public blogforumResult queryListPage(Integer pageSize,Integer pageNo){
		Permision permision = new Permision();
		Page<Permision> page = new Page<>(pageNo, pageSize);
		Page<Permision> queryList = super.queryList(page, permision);
		return blogforumResult.ok(queryList);
	}


}
