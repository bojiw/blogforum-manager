package com.blogforum.manager.service.manager.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogforum.common.tools.DateUtils;
import com.blogforum.manager.pojo.vo.CountVO;
import com.blogforum.manager.pojo.vo.NoteAllCountVO;
import com.blogforum.manager.service.manager.NoteManager;
import com.blogforum.manager.service.note.NoteServer;
import com.blogforum.notebook.common.enums.IsDelFlagEnum;

@Component
public class NoteManagerImpl implements NoteManager {

	@Autowired
	private NoteServer noteServer;
	
	@Override
	public NoteAllCountVO getNoteCount() {
		//所有笔记总数
		CountVO allNoteCount = getStatusCount(null, "所有笔记总数");
		//未删除笔记总数
		CountVO noDelNoteCount = getStatusCount(IsDelFlagEnum.N, "未删除笔记总数");
		//最近一个月笔记总数
		CountVO	lastMonthNoteCount = getDateCount(DateUtils.getLastMonthDate(), "最近一个月笔记总数");
		//最近七天注册笔记总数
		CountVO	lastSevenNoteCount = getDateCount(DateUtils.getLastMonthDate(), "最近七天注册笔记总数");
		NoteAllCountVO allCountVO = new NoteAllCountVO();
		allCountVO.setAllNoteCount(allNoteCount);
		allCountVO.setLastMonthNoteCount(lastMonthNoteCount);
		allCountVO.setLastSevenNoteCount(lastSevenNoteCount);
		allCountVO.setNoDelNoteCount(noDelNoteCount);
		return allCountVO;
	}

	
	/**
	 * 获取时间相关的笔记总数
	 * @param startDate
	 * @param memo
	 * @return
	 * @author: wwd
	 * @time: 2018年3月4日
	 */
	private CountVO getDateCount(Date startDate, String memo){
		Integer dateCount = noteServer.getDateInNote(startDate, new Date(), IsDelFlagEnum.N);
		CountVO dateNoteCount = new CountVO();
		dateNoteCount.setCount(dateCount);
		dateNoteCount.setMemo(memo);
		return dateNoteCount;
	}
	
	/**
	 * 获取状态相关的笔记总数
	 * @param statusEnum
	 * @param memo
	 * @return
	 * @author: wwd
	 * @time: 2018年3月4日
	 */
	private CountVO getStatusCount(IsDelFlagEnum flag,String memo){
		Integer allNoteCount = noteServer.getAllNoteCount(flag);
		CountVO allNoteCountVO = new CountVO();
		allNoteCountVO.setCount(allNoteCount);
		allNoteCountVO.setMemo(memo);
		return allNoteCountVO;
	}
	
}
