package com.micmiu.submarine.system.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户.
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Entity
@Table(name = "T_SYS_USER")
public class User {
	private Long id;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "LOGIN_NAME")
	private String loginName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "OTHER")
	private String other;

	public String getLoginName() {
		return loginName;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getOther() {
		return other;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}