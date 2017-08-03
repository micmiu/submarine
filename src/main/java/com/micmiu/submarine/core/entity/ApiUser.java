package com.micmiu.submarine.core.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * API 接入用户
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/31/2017
 * Time: 00:35
 */
@Entity
@Table(name = "T_API_USER")
public class ApiUser {

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

	private String userName;

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
