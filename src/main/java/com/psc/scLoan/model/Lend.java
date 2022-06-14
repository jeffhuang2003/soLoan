package com.psc.scLoan.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;



/** 
 * 建立日期：2022/6/12 上午 02:36
 * 程式摘要：com.psc.scLoan.model
 * 類別名稱：Lend.java
 * 程式內容說明：借款申請資料
 * @author kunlung
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "PSC_LEND")
public class Lend extends AuditModel implements Serializable {


    private static final long serialVersionUID = 1L;



    @Id
	@Column(name = "ID",columnDefinition = "varchar(50)")
    @ApiModelProperty(value = "編號")
	private String id;

	@NotBlank
	@Column(nullable = false,name = "CUSTOMER_DETAIL_ID", columnDefinition = "varchar(50) ")
    @ApiModelProperty(value = "帳戶代碼")
    private String customer_detail_id;

    @Column(name = "APPLY_DATE", columnDefinition = "DATETIME")
    @ApiModelProperty(value = "借款申請日期")
    private Timestamp apply_date;

    @Column(name = "RATE_EFFICIENT_DATE", columnDefinition = "DATETIME")
    @ApiModelProperty(value = "利息起算日期")
    private Timestamp rate_efficient_date;


    @NotBlank
    @Column(nullable = false,name = "APPLY_NO", columnDefinition = "varchar(100) ")
    @ApiModelProperty(value = "申請書編號")
    private String apply_no;

    @NotBlank
    @Column(nullable = false,name = "APPLY_TYPE", columnDefinition = "varchar(10) ")
    @ApiModelProperty(value = "申請方式")
    private String apply_type;

    @NotBlank
    @Column(nullable = false,name = "APPLY_CATEGORY", columnDefinition = "varchar(10) ")
    @ApiModelProperty(value = "申請總類")
    private String apply_category;

    @NotBlank
    @Column(nullable = false,name = "AMOUNT", columnDefinition = "decimal(10,0)")
    @ApiModelProperty(value = "借款金額")
    private BigDecimal amount;

    @NotBlank
    @Column(nullable = false,name = "FEE", columnDefinition = "decimal(5,0)")
    @ApiModelProperty(value = "借貸手續")
    private BigDecimal fee;

    @NotBlank
    @Column(nullable = false,name = "PAYMENT_AMOUNT", columnDefinition = "decimal(10,0)")
    @ApiModelProperty(value = "淨收付金額")
    private BigDecimal payment_amount;

    @NotBlank
    @Column(nullable = false,name = "REPAYMENT_AMOUNT", columnDefinition = "decimal(10,0)")
    @ApiModelProperty(value = "未還金額")
    private BigDecimal repayment_amount;

    @NotBlank
    @Column(nullable = false,name = "APPLY_REASON", columnDefinition = "CHAR(1) ")
    @ApiModelProperty(value = "借款目的(1:投資上市櫃有價證券、2:期貨市場交易、3:不動產交易、4:其他理財、5:消費性支出、6:資金週轉、7:其他目的)")
    private String apply_reason;

    @NotBlank
    @Column(nullable = false,name = "APPLY_REASON_OTHER", columnDefinition = "nvarchar(50) ")
    @ApiModelProperty(value = "其他目的說明")
    private String apply_reason_other;

    @NotBlank
    @Column(nullable = false,name = "STATUS", columnDefinition = "CHAR(1) ")
    @ApiModelProperty(value = "狀態(1:成功,0:失敗)")
    private String status;


    /**
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the value of customer_detail_id
     */
    public String getCustomer_detail_id() {
        return customer_detail_id;
    }

    /**
     * Sets the customer_detail_id
     */
    public void setCustomer_detail_id(String customer_detail_id) {
        this.customer_detail_id = customer_detail_id;
    }

    /**
     * @return the value of apply_date
     */
    public Timestamp getApply_date() {
        return apply_date;
    }

    /**
     * Sets the apply_date
     */
    public void setApply_date(Timestamp apply_date) {
        this.apply_date = apply_date;
    }

    /**
     * @return the value of rate_efficient_date
     */
    public Timestamp getRate_efficient_date() {
        return rate_efficient_date;
    }

    /**
     * Sets the rate_efficient_date
     */
    public void setRate_efficient_date(Timestamp rate_efficient_date) {
        this.rate_efficient_date = rate_efficient_date;
    }

    /**
     * @return the value of apply_no
     */
    public String getApply_no() {
        return apply_no;
    }

    /**
     * Sets the apply_no
     */
    public void setApply_no(String apply_no) {
        this.apply_no = apply_no;
    }

    /**
     * @return the value of apply_type
     */
    public String getApply_type() {
        return apply_type;
    }

    /**
     * Sets the apply_type
     */
    public void setApply_type(String apply_type) {
        this.apply_type = apply_type;
    }

    /**
     * @return the value of apply_category
     */
    public String getApply_category() {
        return apply_category;
    }

    /**
     * Sets the apply_category
     */
    public void setApply_category(String apply_category) {
        this.apply_category = apply_category;
    }

    /**
     * @return the value of amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the value of payment_amount
     */
    public BigDecimal getPayment_amount() {
        return payment_amount;
    }

    /**
     * Sets the payment_amount
     */
    public void setPayment_amount(BigDecimal payment_amount) {
        this.payment_amount = payment_amount;
    }

    /**
     * @return the value of apply_reason
     */
    public String getApply_reason() {
        return apply_reason;
    }

    /**
     * Sets the apply_reason
     */
    public void setApply_reason(String apply_reason) {
        this.apply_reason = apply_reason;
    }

    /**
     * @return the value of apply_reason_other
     */
    public String getApply_reason_other() {
        return apply_reason_other;
    }

    /**
     * Sets the apply_reason_other
     */
    public void setApply_reason_other(String apply_reason_other) {
        this.apply_reason_other = apply_reason_other;
    }

    /**
     * @return the value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
