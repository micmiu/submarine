package com.micmiu.submarine.core.service.impl;

import com.micmiu.submarine.core.entity.ApiUser;
import com.micmiu.submarine.core.service.ApiUserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 8/1/2017
 * Time: 17:52
 */
@Service
public class ApiUserServiceImpl implements ApiUserService {
	/**
	 * Hibernate Session Factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public ApiUser findByUserName(String userName) {
		return (ApiUser) sessionFactory.getCurrentSession().
				createQuery("from ApiUser where userName=?").setParameter(0, userName).uniqueResult();
	}

	@Override
	public List<ApiUser> queryAll() {
		return (List<ApiUser>) sessionFactory.getCurrentSession().createQuery("from ApiUser").list();
	}

}
