package com.blogforum.manager.service.note.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogforum.manager.integration.note.NoteServerFacadeClient;
import com.blogforum.manager.service.note.NoteServer;
import com.blogforum.notebook.common.enums.IsDelFlagEnum;

@Component
public class NoteServerImpl implements NoteServer {

	@Autowired
	private NoteServerFacadeClient noteServerFacadeClient;
	
	
	@Override
	public Integer getAllNoteCount(IsDelFlagEnum delFlag) {
		return noteServerFacadeClient.getAllNoteCount(delFlag);
	}

	@Override
	public Integer getDateInNote(Date startDate, Date endDate, IsDelFlagEnum delFlag) {
		return noteServerFacadeClient.getDateInNote(startDate, endDate, delFlag);
	}

}
