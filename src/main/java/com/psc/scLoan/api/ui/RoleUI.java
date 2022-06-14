package com.psc.scLoan.api.ui;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "角色資料表")
public class RoleUI extends BasicUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "編號")
	private String id;
	@ApiModelProperty(value = "狀態=1:啟用/0:停用")
	private String status;

	@ApiModelProperty(value = "角色名稱")
	private String name;
	@ApiModelProperty(value = "英文名稱")
	private String enName;

	@ApiModelProperty(value = "狀態=1:啟用/0:停用")
	private String statusName;
	@ApiModelProperty(value = "角色代號")
	private String roleId;

	@ApiModelProperty(value = "角色人員清單")
	private List<UserRoleUI> userRoleList;

	
		
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public List<UserRoleUI> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRoleUI> userRoleList) {
		this.userRoleList = userRoleList;
	}
	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	

}
