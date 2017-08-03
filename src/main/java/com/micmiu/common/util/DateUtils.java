package com.micmiu.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 3/9/2016
 * Time: 14:04
 */
public class DateUtils {

	private static String datePattern = "yyyy-MM-dd";
	private static String dateTimePattern = "yyyy-MM-dd HH:mm:ss";

	public static String formatDate(Date date, String datePattern) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(datePattern);
			return df.format(date);
		} catch (Exception ex) {
			return null;
		}
	}

	public static Date parseDateTime(String datatime) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(dateTimePattern);
			return df.parse(datatime);
		} catch (Exception ex) {
			return null;
		}
	}
}
