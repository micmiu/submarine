package com.micmiu.submarine.core.service.impl;

import com.micmiu.submarine.core.entity.ApiOptLog;
import com.micmiu.submarine.core.service.ApiOptLogService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 8/1/2017
 * Time: 00:26
 */
@Service
public class ApiOptLogServiceImpl implements ApiOptLogService {

	/**
	 * Hibernate Session Factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(ApiOptLog log) {
		sessionFactory.getCurrentSession().save(log);
	}
}
