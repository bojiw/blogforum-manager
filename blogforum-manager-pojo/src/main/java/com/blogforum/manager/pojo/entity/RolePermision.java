/***********************************************************************
 * Module:  RolePermision.java
 * Author:  Administrator
 * Purpose: Defines the Class RolePermision
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

/** 角色权限对应表 */
public class RolePermision extends DataEntity<RolePermision> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 405928405802113589L;

	/**
	 * 编号
	 */
	private Long id;

	private Integer roleId;
	private Integer permisionId;
	
	public RolePermision() {
	}
	public RolePermision(Long id) {
		this.id = id;
	}
	
	public RolePermision(Long id, Integer roleId,Integer permisionId){
		this.id = id;
		this.roleId = roleId;
		this.permisionId = permisionId;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermisionId() {
		return permisionId;
	}

	public void setPermisionId(Integer permisionId) {
		this.permisionId = permisionId;
	}

	@Override
	public String toString() {
		return "RolePermision [id=" + id + ", roleId=" + roleId + ", permisionId=" + permisionId + "]";
	}

}