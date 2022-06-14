package com.psc.scLoan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "options")
public class Options  extends AuditModel   implements Serializable  {
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
	@Column(name = "status", columnDefinition = "varchar(2) ")
	@ApiModelProperty(value = "狀態:啟用/停用")
	private String status;

	@NotBlank
	@Column(name = "val", columnDefinition = "varchar(50) ")
	private String val;
	
	@NotBlank
	@Column(name = "label", columnDefinition = "varchar(50) ")
	private String label;
	
	@NotBlank
	@Column(name = "category", columnDefinition = "varchar(50) ")
	private String category;
	

	
	
	
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
