package com.blogforum.manager.pojo.vo;

public class UserAllCountVO {

	/**
	 * 所有注册用户总数
	 */
	private CountVO	allUserCount;
	/**
	 * 正常状态用户总数
	 */
	private CountVO	activeUserCount;
	/**
	 * 最近一个月注册用户总数
	 */
	private CountVO	lastMonthUserCount;

	/**
	 * 最近七天注册用户总数
	 */
	private CountVO	lastSevenUserCount;

	public CountVO getAllUserCount() {
		return allUserCount;
	}

	public void setAllUserCount(CountVO allUserCount) {
		this.allUserCount = allUserCount;
	}

	public CountVO getActiveUserCount() {
		return activeUserCount;
	}

	public void setActiveUserCount(CountVO activeUserCount) {
		this.activeUserCount = activeUserCount;
	}

	public CountVO getLastMonthUserCount() {
		return lastMonthUserCount;
	}

	public void setLastMonthUserCount(CountVO lastMonthUserCount) {
		this.lastMonthUserCount = lastMonthUserCount;
	}

	public CountVO getLastSevenUserCount() {
		return lastSevenUserCount;
	}

	public void setLastSevenUserCount(CountVO lastSevenUserCount) {
		this.lastSevenUserCount = lastSevenUserCount;
	}

}
