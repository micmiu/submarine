package com.micmiu.submarine.core.service.impl;

import com.micmiu.submarine.core.entity.ApiUserPermission;
import com.micmiu.submarine.core.service.ApiUserPermService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 接入用户的数据权限表
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 8/1/2017
 * Time: 17:52
 */
@Service
public class ApiUserPermServiceImpl implements ApiUserPermService {
	/**
	 * Hibernate Session Factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<ApiUserPermission> findByUserName(String userName) {
		return (List<ApiUserPermission>) sessionFactory.getCurrentSession().
				createQuery("from ApiUserPermission where userName=?").setParameter(0, userName).list();
	}

	@Override
	public List<ApiUserPermission> queryAll() {
		return (List<ApiUserPermission>) sessionFactory.getCurrentSession().createQuery("from ApiUserPermission").list();
	}

}
