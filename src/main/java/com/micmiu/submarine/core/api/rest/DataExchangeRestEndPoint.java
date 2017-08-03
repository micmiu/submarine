package com.micmiu.submarine.core.api.rest;

import com.micmiu.submarine.core.api.DataExchangeService;
import com.micmiu.submarine.core.entity.ApiOptLog;
import com.micmiu.submarine.core.service.ApiDataService;
import com.micmiu.submarine.core.util.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/28/2017
 * Time: 16:58
 */
@Controller
@RequestMapping(value = "/api/rest/")
public class DataExchangeRestEndPoint implements DataExchangeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataExchangeRestEndPoint.class);

	@Autowired
	private ApiDataService apiDataService;

	@Override
	@RequestMapping(value = "/v1/pushdata", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String pushData(String compressType, String docFormat, String reqData) {
		Date startDate = new Date();
		String requestIp = MessageUtils.getRequestIp(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
		ApiOptLog log = new ApiOptLog();
		log.setApiType("rest");
		log.setStartTime(startDate);
		log.setReqMethod("pushData");
		log.setReqIp(requestIp);
		return apiDataService.pushData(log, compressType, docFormat, reqData);
	}

	@Override
	public String pushSimpleData(String reqData) {
		return null;
	}

	@Override
	public String querySimpleData(String reqData) {
		return null;
	}

	@Override
	public String queryData(String compressType, String docFormat, String reqData) {
		return null;
	}
}
