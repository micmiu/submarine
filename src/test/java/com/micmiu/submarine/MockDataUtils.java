package com.micmiu.submarine;

import com.micmiu.submarine.core.model.Request;
import com.micmiu.submarine.core.model.Response;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Mock test data
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 2/24/2016
 * Time: 14:16
 */
public class MockDataUtils {

	public static Request mockRequest(String docFormat, String serviceName) {
		Request request = new Request();

		Request.Header header = request.new Header();
		header.setVersion("1.0");
		header.setRequestTime("2016-03-03 00:30:30");
		header.setAppId("client_ios9");
		header.setUserName("micmiu");
		header.setSign("test");

		Request.Body body = request.new Body();
		body.setDocFormat(docFormat);
		body.setServiceName(serviceName);

		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		Map<String, String> valMap = new LinkedHashMap<String, String>();
		valMap.put("ROWKEY", "10001");
		valMap.put("LASTMT", "2016-03-02 10:18:10");
		valMap.put("CITYCODE ", "200000");
		valMap.put("NAME ", "孙悟空");
		valMap.put("SEX", "男");
		valMap.put("URL", "micmiu.com");
		dataList.add(valMap);

		Map<String, String> valMap2 = new LinkedHashMap<String, String>();
		valMap2.put("ROWKEY", "10002");
		valMap2.put("LASTMT", "2016-03-02 10:18:10");
		valMap2.put("CITYCODE ", "200000");
		valMap2.put("NAME ", "孙小美");
		valMap2.put("BIRTH", "201x-xx-xx");
		valMap2.put("SEX", "女");
		valMap.put("URL", "micmiu.com");
		dataList.add(valMap2);

		body.setDataMapList(dataList);
		request.setHeader(header);
		request.setBody(body);
		return request;
	}


	public static Response mockResponSuccess() {
		Response res = new Response();
		res.setCode(Response.CODE_SUCCESS);
		res.setMessage("successful");
		return res;
	}

	public static Response mockResponFail() {
		Response res = new Response();
		res.setCode(Response.CODE_ERROR_901);
		res.setMessage("参数dataType不能为空");
		return res;
	}

	public static String mockXml4Request() {

		String xml = "<Request>\n" +
				"    <Header>\n" +
				"        <version>1.0</version>\n" +
				"        <requestTime>2012-06-07 09:28:30</requestTime>\n" +
				"        <appId>ios_9</appId>\n" +
				"        <userName>micmiu</userName>\n" +
				"        <sign>3c87defa80cbee6ddc12a1d12e9a8f04</sign>\n" +
				"    </Header>\n" +
				"    <Body DocFormat=\"XML\">\n" +
				"        <serviceName>upload</serviceName>\n" +
				"        <dataList>\n" +
				"            <data>\n" +
				"                <ROWKEY>123456</ROWKEY>\n" +
				"                <AUTHOR>Michael</AUTHOR>\n" +
				"                <URL>micmiu.com</URL>\n" +
				"            </data>\n" +
				"        </dataList>\n" +
				"    </Body>\n" +
				"</Request>";
		return xml;
	}

	public static String mockJson4Reqeust() {
		String json = "{\n" +
				"    \"header\": {\n" +
				"        \"reqId\": \"100001\", \n" +
				"        \"version\": \"1.0\", \n" +
				"        \"requestTime\": \"2012-06-07 09:28:30\", \n" +
				"        \"appId\": \"android_7\", \n" +
				"        \"authType\": null, \n" +
				"        \"userName\": \"micmiu\", \n" +
				"        \"sign\": \"3c87defa80cbee6ddc12a1d12e9a8f04\"\n" +
				"    }, \n" +
				"    \"body\": {\n" +
				"        \"docFormat\": \"json\", \n" +
				"        \"serviceName\": \"upload\", \n" +
				"        \"dataMapList\": [\n" +
				"            {\n" +
				"                \"AUTHOR\": \"Michael\", \n" +
				"                \"ROWKEY\": \"20170803001\", \n" +
				"                \"URL\": \"micmiu.com\"\n" +
				"            }\n" +
				"        ]\n" +
				"    }\n" +
				"}";
		return json;
	}

	public static String mockDataXmlError() {
		return "<Request><Data>demo</Data></Request>";

	}

}
