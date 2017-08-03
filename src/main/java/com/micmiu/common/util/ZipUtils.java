package com.micmiu.common.util;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * zip 工具类
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 3/14/2016
 * Time: 15:13
 */
public class ZipUtils {

	private static final String DEFAUTL_ENTITYNAME = "micmiu";

	/**
	 * 使用zip进行压缩
	 *
	 * @param str 压缩前的文本
	 * @return 返回压缩后的byte[]
	 */
	public static final byte[] zipStr(String str) {
		if (str == null) {
			return null;
		}
		byte[] rest;
		ByteArrayOutputStream baos = null;
		ZipOutputStream zipos = null;
		try {
			baos = new ByteArrayOutputStream();
			zipos = new ZipOutputStream(baos);
			zipos.putNextEntry(new ZipEntry(DEFAUTL_ENTITYNAME));
			zipos.write(str.getBytes("UTF-8"));
			zipos.closeEntry();
			rest = baos.toByteArray();
			return rest;
		} catch (IOException e) {
			return null;
		} finally {
			IOUtils.closeQuietly(zipos);
			IOUtils.closeQuietly(baos);
		}
	}

	/**
	 * 使用zip进行解压缩
	 *
	 * @param zipBytes 压缩后的字节数组
	 * @return 解压后的字符串
	 */
	public static final String unzip2Str(byte[] zipBytes) {
		if (zipBytes == null) {
			return null;
		}

		ByteArrayOutputStream baos = null;
		ByteArrayInputStream bais = null;
		ZipInputStream zipis = null;
		String rest;
		try {
			baos = new ByteArrayOutputStream();
			bais = new ByteArrayInputStream(zipBytes);
			zipis = new ZipInputStream(bais);
			zipis.getNextEntry();
			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = zipis.read(buffer)) != -1) {
				baos.write(buffer, 0, offset);
			}
			rest = baos.toString("UTF-8");
			return rest;
		} catch (IOException e) {
			return null;
		} finally {
			IOUtils.closeQuietly(zipis);
			IOUtils.closeQuietly(bais);
			IOUtils.closeQuietly(baos);
		}
	}

	/**
	 * 使用zip进行压缩
	 *
	 * @param str 压缩前的文本
	 * @return 返回压缩后的Base64编码字符串
	 */
	public static final String zipStr2Base64(String str) {

		try {
			byte[] bytes = zipStr(str);
			return new Base64().encodeAsString(bytes);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 使用zip进行解压缩
	 *
	 * @param base64Str 压缩前的base64编码的字符串
	 * @return 返回解压后的字符串
	 */
	public static final String unzipBase64Str(String base64Str) {

		try {
			return unzip2Str(new Base64().decode(base64Str));
		} catch (Exception e) {
			return null;
		}
	}
}