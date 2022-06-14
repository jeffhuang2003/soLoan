package com.psc.scLoan.api.result;

import java.io.Serializable;
import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.psc.scLoan.api.ui.DrownUI;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//保證序列化json的時候,如果是null的對象,key也會消失
@ApiModel(description = "回傳物件")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListResult<T> extends BasicResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private LinkedList<T> items;

	@ApiModelProperty(value = "下拉選單")
	private DrownUI dropDowns;

	

	public DrownUI getDropDowns() {
		return dropDowns;
	}

	public void setDropDowns(DrownUI dropDowns) {
		this.dropDowns = dropDowns;
	}

	public LinkedList<T> getItems() {
		return items;
	}

	public void setItems(LinkedList<T> items) {
		this.items = items;
	}

}
