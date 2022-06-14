package com.psc.scLoan.api.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class LoginForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "account")
	@NotBlank(message = "帳號不能為空")
	private String account;

	@ApiModelProperty(value = "流水號")
	@NotBlank(message = "密碼不能為空")
	private String pwd;

	public LoginForm() {
		super();
	}

	public LoginForm(String account, String password) {
		this.account = account;
		this.pwd = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
