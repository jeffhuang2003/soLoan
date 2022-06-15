package com.psc.scLoan.api.form;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.psc.scLoan.model.RepayMentStock;

import io.swagger.annotations.ApiModelProperty;

public class RepayMentForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "userId")
	@NotBlank(message = "客戶鍵值不能為空")
	private String userId;

	@ApiModelProperty(value = "year")
	@NotBlank(message = "系統年")
	private String year;

	@ApiModelProperty(value = "month")
	@NotBlank(message = "系統月份")
	private String month;

	@ApiModelProperty(value = "repayAll")
	@NotBlank(message = "全部還款")
	private Boolean repayAll;

	@ApiModelProperty(value = "accountType")
	@NotBlank(message = "帳戶類別")
	private String accountType;

	@ApiModelProperty(value = "repayType")
	@NotBlank(message = "還款方式")
	private String repayType;

	@ApiModelProperty(value = "repayMentStockList")
	@NotNull(message = "股票張數")
	private List<RepayMentStock> repayMentStockList;

	public Boolean getRepayAll() {
		return repayAll;
	}

	public void setRepayAll(Boolean repayAll) {
		this.repayAll = repayAll;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getRepayType() {
		return repayType;
	}

	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}

	public List<RepayMentStock> getRepayMentStockList() {
		return repayMentStockList;
	}

	public void setRepayMentStockList(List<RepayMentStock> repayMentStockList) {
		this.repayMentStockList = repayMentStockList;
	}
}
