package com.micmiu.submarine.system.service;


import com.micmiu.submarine.system.entity.User;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public interface UserService {

	/**
	 * 根据登陆名查找用户
	 *
	 * @param loginName
	 * @return
	 */
	User getUserByLoginName(String loginName);

	/**
	 * 找到登陆用户的信息[登陆名、姓名、密码]
	 *
	 * @param username
	 * @return
	 */
	public String[] findLoginUser(String username);

}
