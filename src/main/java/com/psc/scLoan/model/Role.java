package com.psc.scLoan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "role")
public class Role extends AuditModel implements Serializable {
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
	@Column(name = "name", columnDefinition = "varchar(50) ")
	private String name;
//	@Column(name = "en_name", columnDefinition = "varchar(50)")
//	private String en_name;
	@NotBlank
	@Column(name = "status", columnDefinition = "varchar(2) ")
	private String status;
//
//	@Column(name = "component", columnDefinition = "varchar(100) ")
//	private String component;
//	@Column(name = "sys_role", columnDefinition = "varchar(50) ")
//	private String sys_role;

	
	

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
