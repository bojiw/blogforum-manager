package com.blogforum.manager.common.enums;

public enum RolePermisionSearchEnum {
	
	ROLE("role","通过角色id搜索"),
	PERMISION("permision","通过权限id搜索");
	
	private String type;
	private String memo;
	
	private RolePermisionSearchEnum(String type,String memo){
		this.type = type;
		this.memo = memo;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	

}
