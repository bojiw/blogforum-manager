package com.blogforum.manager.pojo.vo;

public class NoteAllCountVO {

	/**
	 * 所有笔记总数
	 */
	private CountVO	allNoteCount;

	/**
	 * 未删除笔记总数
	 */
	private CountVO	noDelNoteCount;

	/**
	 * 最近一个月笔记总数
	 */
	private CountVO	lastMonthNoteCount;

	/**
	 * 最近七天注册笔记总数
	 */
	private CountVO	lastSevenNoteCount;

	public CountVO getAllNoteCount() {
		return allNoteCount;
	}

	public void setAllNoteCount(CountVO allNoteCount) {
		this.allNoteCount = allNoteCount;
	}

	public CountVO getNoDelNoteCount() {
		return noDelNoteCount;
	}

	public void setNoDelNoteCount(CountVO noDelNoteCount) {
		this.noDelNoteCount = noDelNoteCount;
	}

	public CountVO getLastMonthNoteCount() {
		return lastMonthNoteCount;
	}

	public void setLastMonthNoteCount(CountVO lastMonthNoteCount) {
		this.lastMonthNoteCount = lastMonthNoteCount;
	}

	public CountVO getLastSevenNoteCount() {
		return lastSevenNoteCount;
	}

	public void setLastSevenNoteCount(CountVO lastSevenNoteCount) {
		this.lastSevenNoteCount = lastSevenNoteCount;
	}

}
