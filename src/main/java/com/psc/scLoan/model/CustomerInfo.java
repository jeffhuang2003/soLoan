package com.psc.scLoan.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.IDN;
import java.sql.Timestamp;


/**
 * 建立日期：2022/6/12 上午 01:49
 * 程式摘要：com.psc.scLoan.model
 * 類別名稱：CustomerInfo.java
 * 程式內容說明：客戶基本資料
 * @author kunlung
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "PSC_CUSTOMER_INFO")
public class CustomerInfo extends AuditModel implements Serializable {


    private static final long serialVersionUID = 1L;


    @Id
	@Column(name = "ID",columnDefinition = "varchar(50)")
    @ApiModelProperty(value = "編號")
	private String id;

	@NotBlank
	@Column(nullable = false,name = "IDN", columnDefinition = "varchar(50) ")
    @ApiModelProperty(value = "身分證字號或統一編號")
	private String idn;

	@NotBlank
	@Column(nullable = false,name = "NAME", columnDefinition = "NVARCHAR(100) ")
    @ApiModelProperty(value = "名稱")
	private String name;


    @Column(name = "CREDIT_FACILITIES", columnDefinition = "DECIMAL(10, 0) ")
    @ApiModelProperty(value = "授信額度")
    private String credit_facilities;


    @Column(name = "BORROW_LIMIT", columnDefinition = "DECIMAL(10, 0) ")
    @ApiModelProperty(value = "可借額度")
    private BigDecimal borrow_limit;


    @Column(name = "MAINTENANCE_RATIO", columnDefinition = "DECIMAL(5, 2) ")
    @ApiModelProperty(value = "維持率")
    private BigDecimal maintenance_ratio;


    @Column(name = "RATE_EFFICIENT_DATE", columnDefinition = "DATETIME")
    @ApiModelProperty(value = "利率生效日")
    private Timestamp rate_efficient_date;


    @Column(name = "CONTRACT_EXPIRY_DATE", columnDefinition = "DATETIME")
    @ApiModelProperty(value = "契約到期日")
    private Timestamp contract_expiry_date;


    @Column(name = "LAST_LOGIN_TIME", columnDefinition = "DATETIME")
    @ApiModelProperty(value = "最後登入時間")
    private Timestamp last_login_time;

    @Column(name = "LAST_LOGOUT_TIME", columnDefinition = "DATETIME")
    @ApiModelProperty(value = "最後登出時間")
    private Timestamp last_logout_time;


    @Column(name = "LOGIN_ERROR_COUNT", columnDefinition = "int")
    @ApiModelProperty(value = "登入錯誤次數")
    private Integer login_error_count;


    @Column(name = "CLOSE_TIME", columnDefinition = "DATETIME")
    @ApiModelProperty(value = "停用時間")
    private Timestamp close_time;


    @Column(name = "CLOSE_REASON", columnDefinition = "NVARCHAR(100)")
    @ApiModelProperty(value = "停用原因")
    private String close_reason;


    @Column(name = "SALES_ID", columnDefinition = "CHAR(6)")
    @ApiModelProperty(value = "業務員代碼")
    private Timestamp sales_id;

    @NotBlank
    @Column(nullable = false,name = "STATUS", columnDefinition = "CHAR(1)")
    @ApiModelProperty(value = "狀態(1:啟用 0:停用)")
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
     * @return the value of idn
     */
    public String getIdn() {
        return idn;
    }

    /**
     * Sets the idn
     */
    public void setIdn(String idn) {
        this.idn = idn;
    }

    /**
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value of credit_facilities
     */
    public String getCredit_facilities() {
        return credit_facilities;
    }

    /**
     * Sets the credit_facilities
     */
    public void setCredit_facilities(String credit_facilities) {
        this.credit_facilities = credit_facilities;
    }

    /**
     * @return the value of borrow_limit
     */
    public BigDecimal getBorrow_limit() {
        return borrow_limit;
    }

    /**
     * Sets the borrow_limit
     */
    public void setBorrow_limit(BigDecimal borrow_limit) {
        this.borrow_limit = borrow_limit;
    }

    /**
     * @return the value of maintenance_ratio
     */
    public BigDecimal getMaintenance_ratio() {
        return maintenance_ratio;
    }

    /**
     * Sets the maintenance_ratio
     */
    public void setMaintenance_ratio(BigDecimal maintenance_ratio) {
        this.maintenance_ratio = maintenance_ratio;
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
     * @return the value of contract_expiry_date
     */
    public Timestamp getContract_expiry_date() {
        return contract_expiry_date;
    }

    /**
     * Sets the contract_expiry_date
     */
    public void setContract_expiry_date(Timestamp contract_expiry_date) {
        this.contract_expiry_date = contract_expiry_date;
    }

    /**
     * @return the value of last_login_time
     */
    public Timestamp getLast_login_time() {
        return last_login_time;
    }

    /**
     * Sets the last_login_time
     */
    public void setLast_login_time(Timestamp last_login_time) {
        this.last_login_time = last_login_time;
    }

    /**
     * @return the value of login_error_count
     */
    public Integer getLogin_error_count() {
        return login_error_count;
    }

    /**
     * Sets the login_error_count
     */
    public void setLogin_error_count(Integer login_error_count) {
        this.login_error_count = login_error_count;
    }

    /**
     * @return the value of close_time
     */
    public Timestamp getClose_time() {
        return close_time;
    }

    /**
     * Sets the close_time
     */
    public void setClose_time(Timestamp close_time) {
        this.close_time = close_time;
    }

    /**
     * @return the value of close_reason
     */
    public String getClose_reason() {
        return close_reason;
    }

    /**
     * Sets the close_reason
     */
    public void setClose_reason(String close_reason) {
        this.close_reason = close_reason;
    }

    /**
     * @return the value of sales_id
     */
    public Timestamp getSales_id() {
        return sales_id;
    }

    /**
     * Sets the sales_id
     */
    public void setSales_id(Timestamp sales_id) {
        this.sales_id = sales_id;
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
