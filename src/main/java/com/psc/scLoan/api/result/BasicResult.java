package com.psc.scLoan.api.result;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.psc.scLoan.api.ui.DrownUI;
import com.psc.scLoan.constants.ApiCodeConstants;
import com.psc.scLoan.constants.MessageConstants;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 
//保證序列化json的時候,如果是null的對象,key也會消失
@ApiModel(description = "回傳物件")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code = ApiCodeConstants.SUCCESS_CODE;
	private String message = MessageConstants.MESSAGE_SUCCESS;
	private T item;

	@ApiModelProperty(value = "下拉選單")
	private DrownUI dropDowns;

	public void setAuthFailed() {
		this.code = ApiCodeConstants.SUCCESS_CODE;
		this.message = MessageConstants.MESSAGE_AUTH_FAIL;
	}

	public void setValidateFailWithMessage(String message) {
		this.code = ApiCodeConstants.DATA_ERR_CODE;
		this.message = message;
	}

	public void setSystemError() {
		this.code = ApiCodeConstants.ERROR_CODE;
		this.message = MessageConstants.MESSAGE_SYSTEM_BUSY;
	}

	public void setSystemErrorWithMessage(String message) {
		this.code = ApiCodeConstants.ERROR_CODE;
		this.message = message;
	}

	public DrownUI getDropDowns() {
		return dropDowns;
	}

	public void setDropDowns(DrownUI dropDowns) {
		this.dropDowns = dropDowns;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

}
