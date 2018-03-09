package com.blogforum.manager.service.dao;

import java.util.List;

import com.blogforum.manager.pojo.page.Page;

public interface BaseService<T> {
	void save(T t);

	T getById(T t);
	
	T get(T t);
	
	List<T> queryList(T t);
	
	Page<T> queryList(Page<T> page, T t);
	
	void update(T t);

	public void delete(T t);
	
}
