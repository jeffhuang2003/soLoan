package com.psc.scLoan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class RepayMentStockKey implements Serializable{
	
	@NotBlank
	@Column(name="userId",columnDefinition = "varchar(50)")
	private String userId;
	
	@NotBlank
	@Column(name="stockCode",columnDefinition = "varchar(4)")
	private String stockCode;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
}
