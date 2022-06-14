package com.psc.scLoan.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "repayMentStock")
public class RepayMentStock {

	@EmbeddedId
	private RepayMentStockKey repayMentStockKey;
	
	@NotBlank
	@Column(name = "stockName",nullable = false,  columnDefinition = "varchar(50)")
	private String stockName;
	
	@NotBlank
	@Column(name = "collateralNumber",nullable = false,  columnDefinition = "decimal(10,0)")
	private BigDecimal collateralNumber;
	
	@NotBlank
	@Column(name = "repayMentInterest", nullable = false, columnDefinition = "DECIMAL(15,0)")
	private BigDecimal repayMentInterest;
	
	@NotBlank
	@Column(name = "closePrice",nullable = false,  columnDefinition = "decimal(10,2)")
	private BigDecimal closePrice;
	
	@NotBlank
	@Column(name = "trialCalculPercent",nullable = false,  columnDefinition = "DECIMAL(10,2)")
	private BigDecimal trialCalculPercent;
	
	@NotBlank
	@Column(name = "updateDate",nullable = false, columnDefinition = "DATETIME")
	@LastModifiedDate
	private Timestamp updateDate;

	public RepayMentStockKey getRepayMentStockKey() {
		return repayMentStockKey;
	}

	public void setRepayMentStockKey(RepayMentStockKey repayMentStockKey) {
		this.repayMentStockKey = repayMentStockKey;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public BigDecimal getCollateralNumber() {
		return collateralNumber;
	}

	public void setCollateralNumber(BigDecimal collateralNumber) {
		this.collateralNumber = collateralNumber;
	}

	public BigDecimal getRepayMentInterest() {
		return repayMentInterest;
	}

	public void setRepayMentInterest(BigDecimal repayMentInterest) {
		this.repayMentInterest = repayMentInterest;
	}

	public BigDecimal getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}

	public BigDecimal getTrialCalculPercent() {
		return trialCalculPercent;
	}

	public void setTrialCalculPercent(BigDecimal trialCalculPercent) {
		this.trialCalculPercent = trialCalculPercent;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	
}
