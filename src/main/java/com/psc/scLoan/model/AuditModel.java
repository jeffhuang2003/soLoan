package com.psc.scLoan.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fori.util.DateUtil;
import com.psc.scLoan.constants.Constants;

import io.swagger.annotations.ApiModelProperty;


/**
 * 建立日期：2022/6/12 上午 01:50
 * 程式摘要：com.psc.scLoan.model
 * 類別名稱：AuditModel.java
 * 程式內容說明：共用欄位
 * @author kunlung
 * @version 1.0
 * @since 1.0
 */


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "CREATE_DATE", "MODIFY_DATE" }, allowGetters = true)
public abstract class AuditModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@NotBlank
	@Column(nullable = false, name = "CREATOR", updatable = false, columnDefinition = "varchar(50) ")
	@ApiModelProperty(value = "建立人員")
	private String creator;

	@NotBlank
	@Column(nullable = false,name = "CREATE_DATE", updatable = false, columnDefinition = "DATETIME ")
    @ApiModelProperty(value = "建立時間")
	@CreatedDate
	private Timestamp create_date;

	@NotBlank
	@Column(nullable = false, name = "MODIFIER", columnDefinition = "varchar(50) ")
	@ApiModelProperty(value = "修改人員")
	private String modifier;


	@NotBlank
	@Column(nullable = false, name = "MODIFY_TIME", columnDefinition = "DATETIME ")
	@LastModifiedDate
    @ApiModelProperty(value = "修改時間")
	private Timestamp modify_time;


    /**
     * @return the value of creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Sets the creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return the value of create_date
     */
    public Timestamp getCreate_date() {
        return create_date;
    }

    /**
     * Sets the create_date
     */
    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    /**
     * @return the value of modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * Sets the modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * @return the value of modify_time
     */
    public Timestamp getModify_time() {
        return modify_time;
    }

    /**
     * Sets the modify_time
     */
    public void setModify_time(Timestamp modify_time) {
        this.modify_time = modify_time;
    }
}