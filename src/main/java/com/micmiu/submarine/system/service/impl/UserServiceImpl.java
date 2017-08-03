package com.micmiu.submarine.system.service.impl;


import com.micmiu.submarine.system.entity.User;
import com.micmiu.submarine.system.service.UserService;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理服务类.
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Service
public class UserServiceImpl implements UserService {

	/**
	 * Hibernate Session Factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public String[] findLoginUser(String username) {

		User user = this.getUserByLoginName(username);
		if (null == user) {
			return null;
		} else {
			return new String[]{user.getLoginName(), user.getName(),
					user.getPassword()};
		}
	}


	@Override
	public User getUserByLoginName(String loginName) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("loginName", loginName));
		return (User) c.uniqueResult();
	}

}
