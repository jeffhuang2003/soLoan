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
 * 建立日期：2022/6/12 上午 02:28
 * 程式摘要：com.psc.scLoan.model
 * 類別名稱：Collateral.java
 * 程式內容說明：擔保品資料
 * @author kunlung
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "PSC_COLLATERAL")
public class Collateral extends AuditModel implements Serializable {


    private static final long serialVersionUID = 1L;


    @Id
	@Column(name = "ID",columnDefinition = "varchar(50)")
    @ApiModelProperty(value = "編號")
	private String id;

	@NotBlank
	@Column(nullable = false,name = "CUSTOMER_DETAIL_ID", columnDefinition = "varchar(50) ")
    @ApiModelProperty(value = "帳戶代碼")
	private String customer_detail_id;

	@NotBlank
	@Column(nullable = false,name = "STOCK_NO", columnDefinition = "varchar(100) ")
    @ApiModelProperty(value = "股票代號")
	private String stock_no;

    @NotBlank
    @Column(nullable = false,name = "STOCK_NAME", columnDefinition = "NVARCHAR(50) ")
    @ApiModelProperty(value = "股票名稱")
    private String stock_name;

    @NotBlank
    @Column(nullable = false,name = "QTY", columnDefinition = "int ")
    @ApiModelProperty(value = "張數")
    private String qty;

    @Column(name = "CLOSE_PRICE", columnDefinition = "decimal(14,6)")
    @ApiModelProperty(value = "收盤價")
    private Timestamp close_price;


    @Column(name = "MARKET_VAL", columnDefinition = "DECIMAL(10, 0) ")
    @ApiModelProperty(value = "市值")
    private BigDecimal market_val;


    @Column(name = "ACCOMMODATING", columnDefinition = "DECIMAL(5, 2) ")
    @ApiModelProperty(value = "融通成數")
    private BigDecimal accommodating;

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
     * @return the value of stock_no
     */
    public String getStock_no() {
        return stock_no;
    }

    /**
     * Sets the stock_no
     */
    public void setStock_no(String stock_no) {
        this.stock_no = stock_no;
    }

    /**
     * @return the value of stock_name
     */
    public String getStock_name() {
        return stock_name;
    }

    /**
     * Sets the stock_name
     */
    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
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

    /**
     * @return the value of close_price
     */
    public Timestamp getClose_price() {
        return close_price;
    }

    /**
     * Sets the close_price
     */
    public void setClose_price(Timestamp close_price) {
        this.close_price = close_price;
    }

    /**
     * @return the value of market_val
     */
    public BigDecimal getMarket_val() {
        return market_val;
    }

    /**
     * Sets the market_val
     */
    public void setMarket_val(BigDecimal market_val) {
        this.market_val = market_val;
    }

    /**
     * @return the value of accommodating
     */
    public BigDecimal getAccommodating() {
        return accommodating;
    }

    /**
     * Sets the accommodating
     */
    public void setAccommodating(BigDecimal accommodating) {
        this.accommodating = accommodating;
    }
}
