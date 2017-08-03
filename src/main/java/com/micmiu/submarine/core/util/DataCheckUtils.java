package com.micmiu.submarine.core.util;

import com.micmiu.common.json.Jackson2ExtMapper;
import com.micmiu.common.xml.JacksonXmleExtMapper;
import com.micmiu.submarine.core.compress.Compressor;
import com.micmiu.submarine.core.handler.CompressorHandler;
import com.micmiu.submarine.core.model.Request;
import com.micmiu.submarine.core.model.Response;
import org.apache.commons.lang3.StringUtils;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/29/2017
 * Time: 01:44
 */
public class DataCheckUtils {

	public static boolean checkMethodPara(Response resp, String compressType, String docFormat) {
		if (StringUtils.isEmpty(compressType)) {
			resp.setCode(Response.CODE_ERROR_901);
			resp.setMessage("compressType can't be null.");
			return false;
		}
		if (StringUtils.isEmpty(docFormat)) {
			resp.setCode(Response.CODE_ERROR_901);
			resp.setMessage("docFormat can't be null.");
			return false;
		}

		if (!"json".equalsIgnoreCase(docFormat) && !"xml".equalsIgnoreCase(docFormat)) {
			resp.setCode(Response.CODE_ERROR_902);
			resp.setMessage("docFormat only support 'xml' or 'json'.");
			return false;
		}
		return true;
	}

	public static Request parseReqeustData(Response resp, String compressType, String docFormat, String reqData) {
		if (StringUtils.isEmpty(reqData)) {
			resp.setCode(Response.CODE_ERROR_901);
			resp.setMessage("reqData is null");
			return null;
		}
		Compressor compressor = CompressorHandler.getCompressor(Compressor.Type.valueOf(compressType.toUpperCase()));
		String originData = compressor.decompress(reqData);
		Request request;
		if ("xml".equalsIgnoreCase(docFormat)) {
			request = JacksonXmleExtMapper.INSTANCE.deserXml(originData, Request.class);
		} else if ("json".equalsIgnoreCase(docFormat)) {
			request = Jackson2ExtMapper.INSTANCE.deserJson(originData, Request.class);
		} else {
			resp.setCode(Response.CODE_ERROR_902);
			resp.setMessage("docFormat not support");
			return null;
		}
		return request;
	}

	public static boolean checkRequestHeader(Request request, Response response) {
		Request.Header header = request.getHeader();
		if (null == header) {
			response.setCode(Response.CODE_ERROR_901);
			response.setMessage("参数Header不能为空");
			return false;
		}
		String version = header.getVersion();
		if (null == version || "".equals(version)) {
			response.setCode(Response.CODE_ERROR_901);
			response.setMessage("参数version不能为空");
			return false;
		}
		String requestTime = header.getRequestTime();
		if (null == requestTime || "".equals(requestTime)) {
			response.setCode(Response.CODE_ERROR_901);
			response.setMessage("参数requestTime不能为空");
			return false;
		}
		String appId = header.getAppId();
		if (null == appId || "".equals(appId)) {
			response.setCode(Response.CODE_ERROR_901);
			response.setMessage("参数appId不能为空");
			return false;
		}
		return true;

	}

	public static boolean checkRequestBody(Request request, Response response) {
		Request.Body body = request.getBody();
		if (null == body) {
			response.setCode(Response.CODE_ERROR_901);
			response.setMessage("参数Body不能为空");
			return false;
		}

		String serviceName = body.getServiceName();
		if (null == serviceName || "".equals(serviceName)) {
			response.setCode(Response.CODE_ERROR_901);
			response.setMessage("参数serviceName不能为空");
			return false;
		}
		if (null == body.getDataMapList() || body.getDataMapList().isEmpty()) {
			response.setCode(Response.CODE_ERROR_901);
			response.setMessage("参数dataList不能为空");
			return false;
		}
		return true;

	}
}
