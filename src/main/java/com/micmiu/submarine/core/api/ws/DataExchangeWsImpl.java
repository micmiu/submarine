package com.micmiu.submarine.core.api.ws;

import com.micmiu.submarine.core.api.DataExchangeService;
import com.micmiu.submarine.core.entity.ApiOptLog;
import com.micmiu.submarine.core.service.ApiDataService;
import com.micmiu.submarine.core.util.MessageUtils;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.security.Principal;
import java.util.Date;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/28/2017
 * Time: 16:57
 */
@Component
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
@WebService(endpointInterface = "com.micmiu.submarine.core.api.DataExchangeService", targetNamespace = "http://api.ds4j.micmiu.com")
public class DataExchangeWsImpl implements DataExchangeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataExchangeWsImpl.class);

	@Resource
	private WebServiceContext wsContext;

	@Autowired
	private ApiDataService apiDataService;

	@Override
	@WebMethod(operationName = "pushData")
	public String pushData(String compressType, String docFormat, String reqData) {
		Date startDate = new Date();
		String userName = this.getUserName();
		String requestIp = this.getRequestIp();
		ApiOptLog log = new ApiOptLog();
		log.setApiType("ws");
		log.setStartTime(startDate);
		log.setReqMethod("pushData");
		log.setReqIp(requestIp);
		String autheType = "1";
		if (null != userName) {
			autheType = "0";
			log.setReqUser(userName);
		}
		LOGGER.info("pushdata comperssType = {}, docFormat = {}, at = {}.", compressType, docFormat, startDate);
		return apiDataService.pushData(log, compressType, docFormat, reqData, autheType);
	}

	@Override
	@WebMethod(operationName = "pushSimpleData")
	public String pushSimpleData(String reqData) {
		LOGGER.info("pushdata simple at {}.", new Date());
		return null;
	}

	@Override
	@WebMethod(operationName = "querySimpleData")
	public String querySimpleData(String reqData) {
		return null;
	}

	@Override
	@WebMethod(operationName = "queryData")
	public String queryData(String compressType, String docFormat, String reqData) {
		return null;
	}

	private String getUserName() {
		Principal pr = wsContext.getUserPrincipal();
		if (null == pr) {
			return null;
		} else {
			return pr.getName();
		}
	}

	private String getRequestIp() {
		try {
			MessageContext ctx = wsContext.getMessageContext();
			if (null == ctx) {
				LOGGER.warn(" MessageContext is null");
				return null;
			}
			return MessageUtils.getRequestIp((HttpServletRequest) ctx.get(AbstractHTTPDestination.HTTP_REQUEST));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setApiDataService(ApiDataService apiDataService) {
		this.apiDataService = apiDataService;
	}
}
