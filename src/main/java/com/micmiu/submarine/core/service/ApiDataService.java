package com.micmiu.submarine.core.service;

import com.micmiu.submarine.core.entity.ApiOptLog;
import com.micmiu.submarine.core.model.Request;
import com.micmiu.submarine.core.model.Response;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 3/2/2016
 * Time: 13:28
 */
public interface ApiDataService {

	String pushData(ApiOptLog log, String compressType, String docFormat, String reqData);

	String pushData(ApiOptLog log, String compressType, String docFormat, String reqData, String autheType);

	boolean pushData(Request request, Response resp);

	boolean queryData(Request request, Response resp);

	void createApiLog(ApiOptLog log);
}

