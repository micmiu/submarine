package com.micmiu.submarine.core.handler;

import com.micmiu.submarine.core.service.CacheManageService;
import org.apache.ws.security.WSPasswordCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 3/2/2016
 * Time: 00:54
 */
public class ServerAuthHandler implements CallbackHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServerAuthHandler.class);

	private CacheManageService cacheManageService;

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		String identifier = pc.getIdentifier();
		LOGGER.info("webservice auth user={}", identifier);
		String password = cacheManageService.findPassword(identifier);
		if (null == password) {
			throw new IOException("api user=[" + identifier + "] not exit");
		}
		pc.setPassword(password);
	}

	public void setCacheManageService(CacheManageService cacheManageService) {
		this.cacheManageService = cacheManageService;
	}
}
