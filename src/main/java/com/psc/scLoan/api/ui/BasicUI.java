package com.psc.scLoan.api.ui;

import java.io.Serializable;

import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;

public abstract class BasicUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	@ApiModelProperty(value = "異動日期")
	private String upDtFormatStr;
	@Transient
	@ApiModelProperty(value = "建立日期")
	private String crDtFormatStr;

	@ApiModelProperty(value = "異動人員名稱")
	private String updatedUser;
	

	
	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public String getUpDtFormatStr() {
		return upDtFormatStr;
	}

	public void setUpDtFormatStr(String upDtFormatStr) {
		this.upDtFormatStr = upDtFormatStr;
	}

	public String getCrDtFormatStr() {
		return crDtFormatStr;
	}

	public void setCrDtFormatStr(String crdtFormatStr) {
		this.crDtFormatStr = crdtFormatStr;
	}



}
