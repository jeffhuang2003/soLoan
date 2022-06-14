package com.psc.scLoan.api.form;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class BasicForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "token")
	private String token;

	@ApiModelProperty(value = "流水號")
	private String id;
	@ApiModelProperty(value = "狀態1:啟用/0:停用")
	private String status;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
