package com.micmiu.submarine.core.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 2/24/2016
 * Time: 14:57
 */
public class Response {

	public static final String CODE_SUCCESS = "200";
	public static final String CODE_WARN_NODATA = "201";
	public static final String CODE_ERROR_500 = "500";

	public static final String CODE_ERROR_801 = "801";
	public static final String CODE_ERROR_802 = "802";
	public static final String CODE_ERROR_803 = "803";

	public static final String CODE_ERROR_901 = "901";
	public static final String CODE_ERROR_902 = "902";
	public static final String CODE_ERROR_903 = "903";
	public static final String CODE_ERROR_904 = "904";
	public static final String CODE_ERROR_905 = "905";
	public static final String CODE_ERROR_906 = "906";

	private static final Map<String, String> codeMsgMap = new HashMap<String, String>() {{
		put(CODE_SUCCESS, "OK");
		put(CODE_WARN_NODATA, "未查询到符合条件的数据");
		put(CODE_ERROR_500, "内部错误");
		put(CODE_ERROR_801, "认证失败");
		put(CODE_ERROR_802, "权限不足");
		put(CODE_ERROR_803, "请求超时");
		put(CODE_ERROR_901, "参数不能为空");
		put(CODE_ERROR_902, "参数类型不支持");
		put(CODE_ERROR_903, "参数解析异常");
		put(CODE_ERROR_904, "数据解压异常");
		put(CODE_ERROR_905, "服务不存在");
		put(CODE_ERROR_906, "服务参数校验失败");
	}};

	private String id;

	private String code;

	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		if (null == message && null != code) {
			return null == codeMsgMap.get(code) ? null : codeMsgMap.get(code);
		}
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
