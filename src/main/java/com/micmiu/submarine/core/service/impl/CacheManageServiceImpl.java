package com.micmiu.submarine.core.service.impl;

import com.micmiu.submarine.core.entity.ApiUser;
import com.micmiu.submarine.core.service.ApiUserService;
import com.micmiu.submarine.core.service.CacheManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 8/1/2017
 * Time: 23:41
 */
@Lazy(false)
@Service
public class CacheManageServiceImpl implements CacheManageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CacheManageServiceImpl.class);

	private final Map<String, String> userPasswprdMap = new HashMap<String, String>();

	@Autowired
	private ApiUserService apiUserService;

	@Override
	@PostConstruct
	public void init() {
		LOGGER.info("cache init start at = {}", new Date());
		this.reload();
	}

	@Override
	public void reload() {
		LOGGER.info("cache reload start at = {}", new Date());
		synchronized (userPasswprdMap) {
			List<ApiUser> list = apiUserService.queryAll();
			for (ApiUser user : list) {
				userPasswprdMap.put(user.getUserName(), user.getPassword());
			}
		}

	}

	@Override
	public String findPassword(String userName) {
		String password = userPasswprdMap.get(userName);
		if (null == password) {
			ApiUser user = apiUserService.findByUserName(userName);
			if (null == user) {
				return null;
			} else {
				userPasswprdMap.put(userName, user.getPassword());
				return user.getPassword();
			}
		} else {
			return password;
		}
	}

}
