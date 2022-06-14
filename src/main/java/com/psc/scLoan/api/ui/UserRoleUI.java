package com.psc.scLoan.api.ui;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "角色人員資料表")
public class UserRoleUI extends BasicUI implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "人員編號")
	private String userId;
	@ApiModelProperty(value = "人員名稱")
	private String userName;
	@ApiModelProperty(value = "角色編號")
	private String roleId;
	@ApiModelProperty(value = "角色名稱")
	private String roleName;
	@ApiModelProperty(value = "角色預設首頁")
	private String component;
	@ApiModelProperty(value = "系統角色編號")
	private String systemRoleId;
	
	

	public String getSystemRoleId() {
		return systemRoleId;
	}

	public void setSystemRoleId(String systemRoleId) {
		this.systemRoleId = systemRoleId;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
