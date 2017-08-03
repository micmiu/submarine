package com.micmiu.submarine.core;

import java.util.Map;
import java.util.UUID;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 3/2/2016
 * Time: 15:25
 */
public class MyUtils {

	public static String getUUID() {
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}

	public static String getApiMessage(String code) {
		return null;
	}

	public static String map2String(Map<String, String> dataMap) {
		StringBuffer sb = new StringBuffer("[");
		for (Map.Entry<String, String> entry : dataMap.entrySet()) {
			sb.append(entry.getKey() + " = " + entry.getValue() + ", ");
		}
		return sb.append("]").toString();
	}

	public static Integer sumCount(String succ, String fail) {
		return parseCountInt(succ) + parseCountInt(fail);
	}

	public static int parseCountInt(String str) {
		if (null == str || "".equals(str)) {
			return 0;
		}
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static String substrXMlByName(String xmlStr, String nodeName) {
		if (null == xmlStr || "".equals(xmlStr) || null == nodeName || "".equals(nodeName)) {
			return null;
		}
		int sindex = xmlStr.indexOf("<" + nodeName + ">");
		if (sindex < 0) {
			return null;
		}
		int start = xmlStr.indexOf("<" + nodeName + ">") + 2 + nodeName.length();
		int end = xmlStr.indexOf("</" + nodeName + ">");
		if (end >= start) {
			return xmlStr.substring(start, end).trim();
		}
		return null;
	}


}
