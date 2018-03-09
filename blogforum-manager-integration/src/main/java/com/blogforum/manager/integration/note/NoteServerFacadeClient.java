package com.blogforum.manager.integration.note;

import java.util.Date;

import com.blogforum.notebook.common.enums.IsDelFlagEnum;

public interface NoteServerFacadeClient {
	
	
	

	/**
	 * 获取对应状态笔记总数或者所有笔记总数
	 * @param delFlag 如果为空获取所有状态笔记总数
	 * @return
	 * @author: wwd
	 * @time: 2018年3月3日
	 */
	Integer getAllNoteCount(IsDelFlagEnum delFlag);
	
	
	/**
	 * 获取指定时间段的笔记数
	 * @param staterDate 开始时间
	 * @param endDate 结束时间
	 * @param delFlag 如果为空获取所有在线和删除笔记总数
	 * @return
	 * @author: wwd
	 * @time: 2018年3月3日
	 */
	Integer getDateInNote(Date startDate,Date endDate,IsDelFlagEnum delFlag);

}
