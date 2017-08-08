package com.micmiu.submarine.core.service;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 8/1/2017
 * Time: 23:39
 */
public interface CacheManageService {

	void init();

	void reload();

	String findPassword(String userName);

	boolean checkUserPerm(String key, String optPerm);
}
