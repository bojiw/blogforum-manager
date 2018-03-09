package com.blogforum.manager.service.manager;

import com.blogforum.manager.pojo.vo.NoteAllCountVO;

public interface NoteManager {

	/**
	 * 获取后台首页笔记总数相关信息
	 * @return
	 * @author: wwd
	 * @time: 2018年3月4日
	 */
	NoteAllCountVO getNoteCount();
}
