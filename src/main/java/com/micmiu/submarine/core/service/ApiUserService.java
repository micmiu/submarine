package com.micmiu.submarine.core.service;

import com.micmiu.submarine.core.entity.ApiUser;

import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 8/1/2017
 * Time: 00:26
 */
public interface ApiUserService {

	List<ApiUser> queryAll();

	ApiUser findByUserName(String userName);
}
