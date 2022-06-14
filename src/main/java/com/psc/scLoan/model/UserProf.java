package com.psc.scLoan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "userProf")
public class UserProf extends AuditModel implements Serializable {
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
	@Column(name = "account", columnDefinition = "varchar(50) ")
	private String account;

	@NotBlank
	@Column(name = "dept", columnDefinition = "varchar(50) ")
	private String dept;

	@NotBlank
	@Column(name = "email", columnDefinition = "varchar(50) ")
	private String email;

	@NotBlank
	@Column(name = "status", columnDefinition = "varchar(2) ")
	private String status;

	@NotBlank
	@Column(name = "name", columnDefinition = "varchar(50) ")
	private String name;

	@NotBlank
	@Column(name = "enName", columnDefinition = "varchar(50) ")
	private String enName;

	

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String en_name) {
		this.enName = en_name;
	}

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

}
