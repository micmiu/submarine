package com.micmiu.submarine.core.service;

import com.micmiu.submarine.core.entity.ApiUserPermission;

import java.util.List;

/**
 * 接入用户数据权限
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 8/1/2017
 * Time: 00:26
 */
public interface ApiUserPermService {

	List<ApiUserPermission> queryAll();

	List<ApiUserPermission> findByUserName(String userName);
}
