package com.psc.scLoan.api.ui;

import java.io.Serializable;
import java.util.List;

import com.psc.scLoan.model.RepayMentCash;
import com.psc.scLoan.model.RepayMentStock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "還款申請資料表")
public class RepayMentUI  implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "現金還款清單{\"id\":\"鍵值\",\"userId\":\"客戶鍵值\",\"repayMentYear\":\"還款年\",\"repayMentMonth\":\"還款月份\""
			+ ",\"repayMentDate\":\"還款日\",\"repayMentInterest\":\"還款利息\",\"trialCalculPercent\":\"試算維持率\",,\"repayMentPrincipal\":\"還款本金\""
			+ ",\"repayMentTotalAmt\":\"還款總金額\",\"updateDate\":\"更新日\"}")
	private RepayMentCash repayMentCash;
	
	
	@ApiModelProperty(value = "賣股還款清單{\"userId\":\"客戶鍵值\",\"stockCode\":\"股票代號\",\"collateralNumber\":\"擔保品張數\",\"repayMentInterest\":\"還款利息\""
			+ ",\"closePrice\":\"收盤價\",\"trialCalculPercent\":\"試算維持率\",\"updateDate\":\"更新日\"}")
	private List<RepayMentStock> repayMentStockList;


	public RepayMentCash getRepayMentCash() {
		return repayMentCash;
	}


	public void setRepayMentCash(RepayMentCash repayMentCash) {
		this.repayMentCash = repayMentCash;
	}


	public List<RepayMentStock> getRepayMentStockList() {
		return repayMentStockList;
	}


	public void setRepayMentStockList(List<RepayMentStock> repayMentStockList) {
		this.repayMentStockList = repayMentStockList;
	}
}
