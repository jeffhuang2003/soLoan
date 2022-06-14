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
@Table(name = "repayMentCash")
public class RepayMentCash {
	
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
	@Column(name = "repayMentInterest", nullable = false, columnDefinition = "DECIMAL(15,0)")
	private BigDecimal repayMentInterest;
	
	@NotBlank
	@Column(name = "trialCalculPercent",nullable = false,  columnDefinition = "DECIMAL(10,2)")
	private BigDecimal trialCalculPercent;
	
	@NotBlank
	@Column(name = "repayMentPrincipal",nullable = false,  columnDefinition = "DECIMAL(15,0)")
	private BigDecimal repayMentPrincipal;
	
	@NotBlank
	@Column(name = "repayMentTotalAmt",nullable = false,  columnDefinition = "DECIMAL(15,0)")
	private BigDecimal repayMentTotalAmt;
	
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

	public Timestamp getRepayMentDate() {
		return repayMentDate;
	}

	public void setRepayMentDate(Timestamp repayMentDate) {
		this.repayMentDate = repayMentDate;
	}

	public BigDecimal getRepayMentInterest() {
		return repayMentInterest;
	}

	public void setRepayMentInterest(BigDecimal repayMentInterest) {
		this.repayMentInterest = repayMentInterest;
	}

	public BigDecimal getTrialCalculPercent() {
		return trialCalculPercent;
	}

	public void setTrialCalculPercent(BigDecimal trialCalculPercent) {
		this.trialCalculPercent = trialCalculPercent;
	}

	public BigDecimal getRepayMentPrincipal() {
		return repayMentPrincipal;
	}

	public void setRepayMentPrincipal(BigDecimal repayMentPrincipal) {
		this.repayMentPrincipal = repayMentPrincipal;
	}

	public BigDecimal getRepayMentTotalAmt() {
		return repayMentTotalAmt;
	}

	public void setRepayMentTotalAmt(BigDecimal repayMentTotalAmt) {
		this.repayMentTotalAmt = repayMentTotalAmt;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
}
