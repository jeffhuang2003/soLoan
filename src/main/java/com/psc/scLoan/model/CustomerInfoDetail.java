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
 * 建立日期：2022/6/12 上午 02:23
 * 程式摘要：com.psc.scLoan.model
 * 類別名稱：CustomerInfoDetail.java
 * 程式內容說明：客戶基本資料帳戶明細資料
 * @author kunlung
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "PSC_CUSTOMER_INFO_DETAIL")
public class CustomerInfoDetail extends AuditModel implements Serializable {


    private static final long serialVersionUID = 1L;


    @Id
	@Column(name = "ID",columnDefinition = "varchar(50)")
    @ApiModelProperty(value = "編號")
	private String id;

	@NotBlank
	@Column(nullable = false,name = "CUSTOMER_INFO_ID", columnDefinition = "varchar(50) ")
    @ApiModelProperty(value = "客戶基本資料編號")
	private String customer_info_id;

	@NotBlank
	@Column(nullable = false,name = "ACCOUNT", columnDefinition = "varchar(50) ")
    @ApiModelProperty(value = "帳戶")
	private String account;

    @NotBlank
    @Column(nullable = false,name = "BRANCH_TYPE", columnDefinition = "CHAR(1) ")
    @ApiModelProperty(value = "分公司狀態(1:總公司,2:分公司)")
    private String branch_type;

    @NotBlank
    @Column(nullable = false,name = "STATUS", columnDefinition = "CHAR(1) ")
    @ApiModelProperty(value = "帳戶狀態(1:啟用,0:停用)")
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
     * @return the value of customer_info_id
     */
    public String getCustomer_info_id() {
        return customer_info_id;
    }

    /**
     * Sets the customer_info_id
     */
    public void setCustomer_info_id(String customer_info_id) {
        this.customer_info_id = customer_info_id;
    }

    /**
     * @return the value of account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return the value of branch_type
     */
    public String getBranch_type() {
        return branch_type;
    }

    /**
     * Sets the branch_type
     */
    public void setBranch_type(String branch_type) {
        this.branch_type = branch_type;
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
