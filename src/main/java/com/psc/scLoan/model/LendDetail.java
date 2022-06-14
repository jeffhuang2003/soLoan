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
 * 建立日期：2022/6/12 上午 02:43
 * 程式摘要：com.psc.scLoan.model
 * 類別名稱：LendDetail.java
 * 程式內容說明：借款申請明細表
 * @author kunlung
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "PSC_LEND_DETAIL")
public class LendDetail extends AuditModel implements Serializable {


    private static final long serialVersionUID = 1L;



    @Id
	@Column(name = "ID",columnDefinition = "varchar(50)")
    @ApiModelProperty(value = "編號")
	private String id;

    @NotBlank
    @Column(nullable = false,name = "COLLATERAL_ID", columnDefinition = "varchar(50) ")
    @ApiModelProperty(value = "擔保品代碼")
    private String collateral_id;

    @NotBlank
    @Column(nullable = false,name = "LEND_ID", columnDefinition = "varchar(50) ")
    @ApiModelProperty(value = "借款申請代碼")
    private String lend_id;

    @NotBlank
    @Column(nullable = false,name = "QTY", columnDefinition = "int ")
    @ApiModelProperty(value = "張數")
    private String qty;


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
     * @return the value of collateral_id
     */
    public String getCollateral_id() {
        return collateral_id;
    }

    /**
     * Sets the collateral_id
     */
    public void setCollateral_id(String collateral_id) {
        this.collateral_id = collateral_id;
    }

    /**
     * @return the value of lend_id
     */
    public String getLend_id() {
        return lend_id;
    }

    /**
     * Sets the lend_id
     */
    public void setLend_id(String lend_id) {
        this.lend_id = lend_id;
    }

    /**
     * @return the value of qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * Sets the qty
     */
    public void setQty(String qty) {
        this.qty = qty;
    }
}
