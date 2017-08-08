package com.micmiu.submarine.core.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * API 接入用户数据权限
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/31/2017
 * Time: 00:35
 */
@Entity
@Table(name = "T_API_USER_PERM")
public class ApiUserPermission implements Serializable {

	private static final long serialVersionUID = 6051018033228133103L;

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

	/**
	 * 数据源
	 */
	private String dsType;

	/**
	 * 表
	 */
	private String tableName;

	/**
	 * 操作权限
	 */
	private String optPerm;

	public String getDsType() {
		return dsType;
	}

	public void setDsType(String dsType) {
		this.dsType = dsType;
	}

	public String getOptPerm() {
		return optPerm;
	}

	public void setOptPerm(String optPerm) {
		this.optPerm = optPerm;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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
