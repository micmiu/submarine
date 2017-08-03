package com.micmiu.submarine.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 3/4/2016
 * Time: 17:36
 */
public class MessageUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageUtils.class);

	public static String getRequestIp(HttpServletRequest request) {
		try {
			if (null == request) {
				LOGGER.warn("Request is null, ip can't fetch. ");
				return null;
			}
			String ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String sercuryUserName(String username) {
		if (null == username || "".equals(username)) {
			return "";
		}
		try {

			if (username.length() == 1) {
				return username;
			} else if (username.length() == 2) {
				return username.substring(0, 1) + "*";
			} else {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < username.length() - 2; i++) {
					sb.append("*");
				}
				return username.substring(0, 1) + sb.toString() + username.substring(username.length() - 1);
			}
		} catch (Exception e) {
			return username;
		}
	}

	public static String sercuryAddr(String addr) {
		return addr.replaceAll("\\d", "*");
	}


	public static void main(String[] args) {
		System.out.println(sercuryUserName("我"));
		System.out.println(sercuryUserName("我们"));
		System.out.println(sercuryUserName("我们很好"));
		System.out.println(sercuryAddr("浙江省.杭州市.西湖区.翠苑街道.花园北村13-2-201"));
	}

}
