/***********************************************************************
 * Module:  Role.java
 * Author:  Administrator
 * Purpose: Defines the Class Role
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;
import java.util.List;

/** 角色表 */
public class Role extends DataEntity<Role> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8159997397538012648L;
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 创建者
	 */
	private String createUser;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 删除标记 N为不删除 Y为删除
	 */
	private String delFlag;

	/**
	 * 拥有的权限
	 */
	private List<Permision> permisions;
	
	
	public Role() {
	}
	public Role(int id) {
		this.id = id;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public List<Permision> getPermisions() {
		return permisions;
	}

	public void setPermisions(List<Permision> permisions) {
		this.permisions = permisions;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", createBy=" + createUser + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", remarks=" + remarks + ", delFlag=" + delFlag + ", permisions="
				+ permisions + "]";
	}

}