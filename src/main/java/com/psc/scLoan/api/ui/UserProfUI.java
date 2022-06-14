package com.psc.scLoan.api.ui;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "人員資料表")
public class UserProfUI extends BasicUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "流水號")
	private String id;

	@ApiModelProperty(value = "帳號")
	private String account;

	@ApiModelProperty(value = "部門名稱")
	private String dept;

	@ApiModelProperty(value = "email")
	private String email;

	@ApiModelProperty(value = "狀態=1:在職/0:離職")
	private String status;

	@ApiModelProperty(value = "中文姓名")
	private String name;

	@ApiModelProperty(value = "英文姓名")
	private String enName;

	@ApiModelProperty(value = "狀態=1:在職/0:離職")
	private String statusName;

	@ApiModelProperty(value = "JWT")
	private String jsonWebToken;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJsonWebToken() {
		return jsonWebToken;
	}

	public void setJsonWebToken(String jsonWebToken) {
		this.jsonWebToken = jsonWebToken;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
