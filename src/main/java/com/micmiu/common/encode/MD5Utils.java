package com.micmiu.common.encode;

import java.security.MessageDigest;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/4/2016
 * Time: 15:28
 */
public class MD5Utils {

	private static final String ALGORITHM = "MD5";

	private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	/**
	 * encode string
	 *
	 * @param str
	 * @return String
	 */
	public static String encode(String str) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
			messageDigest.update(str.getBytes());
			return getFormattedText(messageDigest.digest());
		} catch (Exception e) {
			return null;
		}

	}


	/**
	 * Takes the raw bytes from the digest and formats them correct.
	 *
	 * @param bytes the raw bytes from the digest.
	 * @return the formatted bytes.
	 */
	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		System.out.println("111111 MD5  :" + MD5Utils.encode("111111"));
	}

}