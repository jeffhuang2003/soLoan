package com.psc.scLoan.api.ui;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "客戶資訊及帳務資訊")
public class CustomerInfoUI extends BasicUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "流水號")
	private String id;
	
	@ApiModelProperty(value = "中文姓名")
	private String name;
	
	@ApiModelProperty(value = "分公司狀態(1:總公司,2:分公司)")
	private String branch_type;
	
	@ApiModelProperty(value = "帳戶")
	private String account;
	
	@ApiModelProperty(value = "可借額度")
	private BigDecimal borrow_limit;

	
	/*TODO 
	 * 1.融通額度、已借金額欄位命名
	 * 
	 * 
	 * */
	
	
	@ApiModelProperty(value = "維持率")
	private BigDecimal maintenance_ratio;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch_type() {
		return branch_type;
	}

	public void setBranch_type(String branch_type) {
		this.branch_type = branch_type;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public BigDecimal getBorrow_limit() {
		return borrow_limit;
	}

	public void setBorrow_limit(BigDecimal borrow_limit) {
		this.borrow_limit = borrow_limit;
	}

	public BigDecimal getMaintenance_ratio() {
		return maintenance_ratio;
	}

	public void setMaintenance_ratio(BigDecimal maintenance_ratio) {
		this.maintenance_ratio = maintenance_ratio;
	}
}
