package com.blogforum.manager.pojo.vo;

import com.blogforum.manager.pojo.entity.Permision;
import com.blogforum.manager.pojo.entity.Role;

public class RolePermisionVO {

	/**
	 * 关联表id
	 */
	private Long	id;
	/**
	 * 角色名
	 */
	private String	roleName;
	/**
	 * 权限名
	 */
	private String	permisionName;
	/**
	 * 权限路径
	 */
	private String	permisionController;

	public RolePermisionVO() {
	}

	public RolePermisionVO(Long id, Role role, Permision permision) {
		this.id = id;
		this.roleName = role.getName();
		this.permisionName = permision.getName();
		this.permisionController = permision.getController();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPermisionName() {
		return permisionName;
	}

	public void setPermisionName(String permisionName) {
		this.permisionName = permisionName;
	}

	public String getPermisionController() {
		return permisionController;
	}

	public void setPermisionController(String permisionController) {
		this.permisionController = permisionController;
	}

}
