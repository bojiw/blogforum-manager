package com.blogforum.manager.integration.note.impl;

import java.util.Date;

import com.blogforum.common.model.Result;
import com.blogforum.common.tools.rpc.BaseInvocation;
import com.blogforum.common.tools.rpc.ServiceTemplate;
import com.blogforum.manager.integration.note.NoteServerFacadeClient;
import com.blogforum.notebook.common.enums.IsDelFlagEnum;
import com.blogforum.notebook.facade.note.NoteServerFacade;

public class NoteServerFacadeClientImpl implements NoteServerFacadeClient {

	private NoteServerFacade noteServerFacade;
	
	@Override
	public Integer getAllNoteCount(final IsDelFlagEnum delFlag) {
		return ServiceTemplate.invoke(new BaseInvocation<Integer>() {

			@Override
			public Result<Integer> execute() {
				return noteServerFacade.getAllNoteCount(delFlag);
			}
		});
	}

	@Override
	public Integer getDateInNote(final Date startDate,final Date endDate,final IsDelFlagEnum delFlag) {
		return ServiceTemplate.invoke(new BaseInvocation<Integer>() {

			@Override
			public Result<Integer> execute() {
				return noteServerFacade.getDateInNote(startDate, endDate, delFlag);
			}
		});
	}

	public void setNoteServerFacade(NoteServerFacade noteServerFacade) {
		this.noteServerFacade = noteServerFacade;
	}
	
	

}
