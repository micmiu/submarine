package com.micmiu.submarine.core.service.impl;

import com.micmiu.common.encode.MD5Utils;
import com.micmiu.submarine.core.MyUtils;
import com.micmiu.submarine.core.entity.ApiOptLog;
import com.micmiu.submarine.core.handler.MsgOutHandler;
import com.micmiu.submarine.core.model.Request;
import com.micmiu.submarine.core.model.Response;
import com.micmiu.submarine.core.service.ApiDataService;
import com.micmiu.submarine.core.service.ApiOptLogService;
import com.micmiu.submarine.core.service.CacheManageService;
import com.micmiu.submarine.core.util.DataCheckUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 3/2/2016
 * Time: 13:35
 */
@Service
public class ApiDataServiceImpl implements ApiDataService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiDataServiceImpl.class);

	@Autowired
	private ApiOptLogService logService;

	@Autowired
	private CacheManageService cacheManageService;

	@Override
	public String pushData(ApiOptLog log, String compressType, String docFormat, String reqData) {
		return pushData(log, compressType, docFormat, reqData, "1");
	}

	@Override
	public String pushData(ApiOptLog log, String compressType, String docFormat, String reqData, String autheType) {
		Date startDate = log.getStartTime();
		String uuid = MyUtils.getUUID();
		log.setUuid(uuid);
		LOGGER.info("pushdata uuid={}, compressType = {}, docFormat = {}, start at = {}.", uuid, compressType, docFormat, startDate);
		Response resp = new Response();
		try {
			if (!DataCheckUtils.checkMethodPara(resp, compressType, docFormat)) {
				return MsgOutHandler.outResponse(resp, docFormat);
			}
			Request request = DataCheckUtils.parseReqeustData(resp, compressType, docFormat, reqData);
			if (null == request) {
				resp.setCode(Response.CODE_ERROR_901);
				resp.setMessage("Parse to Request is null.");
				return MsgOutHandler.outResponse(resp, docFormat);
			}
			if (DataCheckUtils.checkRequestHeader(request, resp) && DataCheckUtils.checkRequestBody(request, resp)) {
				if ("0".equals(autheType) || "-1".equals(request.getHeader().getAuthType())
						|| (checkAuth(request, resp) && checkPerm(request, resp))) {
					this.pushData(request, resp);
				}
			}
			if (null == log.getReqUser()) {
				log.setReqUser(request.getHeader().getUserName());
			}
			log.setReqTime(request.getHeader().getRequestTime());
			log.setReqId(request.getHeader().getReqId());
			log.setServiceName(request.getBody().getServiceName());
			LOGGER.info("pushdata uuid={}, comperssType = {}, docFormat = {}, end at = {}.", uuid, compressType, docFormat, new Date());
		} catch (Exception e) {
			LOGGER.error("push data error:", e);
			resp.setCode(Response.CODE_ERROR_500);
			resp.setMessage(e.getLocalizedMessage());
		} finally {
			log.setRespCode(resp.getCode());
			log.setRespMsg(resp.getMessage());
			log.setEndTime(new Date());
			log.setConsumeTimes(log.getEndTime().getTime() - startDate.getTime());
			logService.create(log);
		}

		return MsgOutHandler.outResponse(resp, docFormat);
	}

	@Override
	public boolean pushData(Request request, Response resp) {
		LOGGER.info("TODO PushData start >>>>>>>>>>>>>>>>");
		List<Map<String, String>> dataList = request.getBody().getDataMapList();
		LOGGER.info("pushData datalist size = " + dataList.size());
		for (Map<String, String> data : dataList) {
			LOGGER.info("push data info = " + MyUtils.map2String(data));
		}
		resp.setCode(Response.CODE_SUCCESS);
		LOGGER.info("TODO PushData End  <<<<<<<<<<<<<<<<");
		return true;
	}

	@Override
	public boolean queryData(Request request, Response resp) {
		LOGGER.info("TODO queryData ......");
		resp.setCode(Response.CODE_SUCCESS);
		return true;
	}

	@Override
	public void createApiLog(ApiOptLog log) {
		logService.create(log);
	}

	private boolean checkAuth(Request resquest, Response resp) {
		String sign = resquest.getHeader().getSign();
		String userName = resquest.getHeader().getUserName();
		if (null == userName || "".equals(userName)) {
			resp.setCode(Response.CODE_ERROR_801);
			resp.setMessage("参数userName不能为空");
			return false;
		}
		if (null == sign || "".equals(sign)) {
			resp.setCode(Response.CODE_ERROR_801);
			resp.setMessage("参数sign不能为空");
			return false;
		}
		String password = cacheManageService.findPassword(userName);
		if (null == password) {
			resp.setCode(Response.CODE_ERROR_801);
			resp.setMessage("用户不存在");
			return false;
		}
		if (!sign.equalsIgnoreCase(MD5Utils.encode(userName + resquest.getHeader().getRequestTime() + password))) {
			resp.setCode(Response.CODE_ERROR_801);
			resp.setMessage("参数sign认证失败");
			return false;
		}
		return true;
	}

	private boolean checkPerm(Request resquest, Response resp) {
		String serviceName = resquest.getBody().getServiceName();
		String userName = resquest.getHeader().getUserName();
		String tableName = resquest.getBody().getTableName();
		String dsType = resquest.getBody().getDataSourceType();
		String key = userName + ":" + dsType + ":" + tableName;
		boolean isPerm = false;
		if ("upload".equals(serviceName)) {
			isPerm = cacheManageService.checkUserPerm(key, "create");
		} else {
			isPerm = cacheManageService.checkUserPerm(key, "read");
		}
		if (!isPerm) {
			resp.setCode(Response.CODE_ERROR_802);
			resp.setMessage("资源权限不足");
		}
		return isPerm;
	}
}
