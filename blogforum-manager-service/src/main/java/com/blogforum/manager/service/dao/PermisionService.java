package com.blogforum.manager.service.dao;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.Permision;

public interface PermisionService extends BaseService<Permision> {
	
	/**
	 * 查询分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @author: wwd
	 * @time: 2018年3月4日
	 */
	blogforumResult queryListPage(Integer pageSize,Integer pageNo);

}
