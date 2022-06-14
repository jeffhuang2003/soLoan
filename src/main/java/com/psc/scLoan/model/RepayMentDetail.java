package com.psc.scLoan.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "repayMentDetail")
public class RepayMentDetail {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "varchar(50)")
	private String id;
	
	@NotBlank
	@Column(name = "userId", columnDefinition = "varchar(50)")
	private String userId;
	
	@NotBlank
	@Column(name = "repayMentYear",nullable = false, columnDefinition = "varchar(4)")
	private String repayMentYear;
	
	@NotBlank
	@Column(name = "repayMentMonth",nullable = false, columnDefinition = "varchar(2)")
	private String repayMentMonth;
	
	@NotBlank
	@Column(name = "repayMentDate",nullable = false, columnDefinition = "DATETIME")
	@LastModifiedDate
	private Timestamp repayMentDate;
	
	@NotBlank
	@Column(name = "restDate",nullable = false, columnDefinition = "DATETIME")
	@LastModifiedDate
	private Timestamp restDate;
	
	@NotBlank
	@Column(name = "repayMentInterest",nullable = false,  columnDefinition = "DECIMAL(15,0)")
	private BigDecimal repayMentInterest;
	
	@NotBlank
	@Column(name = "repayMentAmount",nullable = false,  columnDefinition = "DECIMAL(15,0)")
	private BigDecimal repayMentAmount;
	
	@NotBlank
	@Column(name = "status",nullable = false,  columnDefinition = "varchar(2)")
	private String status;
	
	@NotBlank
	@Column(name = "applicationNumber",nullable = false,  columnDefinition = "varchar(10)")
	private String applicationNumber;
	
	
	@NotBlank
	@Column(name = "collateralNumber",nullable = false,  columnDefinition = "decimal(10,0)")
	private BigDecimal collateralNumber;
	
	@NotBlank
	@Column(name = "updateDate",nullable = false, columnDefinition = "DATETIME")
	@LastModifiedDate
	private Timestamp updateDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRepayMentYear() {
		return repayMentYear;
	}

	public void setRepayMentYear(String repayMentYear) {
		this.repayMentYear = repayMentYear;
	}

	public String getRepayMentMonth() {
		return repayMentMonth;
	}

	public void setRepayMentMonth(String repayMentMonth) {
		this.repayMentMonth = repayMentMonth;
	}

	public Timestamp getRepayMentDate() {
		return repayMentDate;
	}

	public void setRepayMentDate(Timestamp repayMentDate) {
		this.repayMentDate = repayMentDate;
	}

	public Timestamp getRestDate() {
		return restDate;
	}

	public void setRestDate(Timestamp restDate) {
		this.restDate = restDate;
	}

	public BigDecimal getRepayMentInterest() {
		return repayMentInterest;
	}

	public void setRepayMentInterest(BigDecimal repayMentInterest) {
		this.repayMentInterest = repayMentInterest;
	}

	public BigDecimal getRepayMentAmount() {
		return repayMentAmount;
	}

	public void setRepayMentAmount(BigDecimal repayMentAmount) {
		this.repayMentAmount = repayMentAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public BigDecimal getCollateralNumber() {
		return collateralNumber;
	}

	public void setCollateralNumber(BigDecimal collateralNumber) {
		this.collateralNumber = collateralNumber;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
}
