package com.blogforum.manager.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.vo.NoteAllCountVO;
import com.blogforum.manager.service.manager.NoteManager;

@Controller
@RequestMapping("/note")
public class NoteController {

	@Autowired
	private NoteManager noteManager;
	
	@RequestMapping("/getCount.action")
	@ResponseBody
	private blogforumResult getCount(){
		NoteAllCountVO noteCount = noteManager.getNoteCount();
		return blogforumResult.ok(noteCount);
	}
	
}
