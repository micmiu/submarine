package com.micmiu.submarine.core.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
import java.util.Map;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 2/23/2016
 * Time: 17:47
 */
@JacksonXmlRootElement(localName = "Request", namespace = "")
public class Request {


	@JacksonXmlProperty(localName = "Header")
	private Header header;

	@JacksonXmlProperty(localName = "Body")
	private Body body;

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Header getHeader() {
		return header;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Request{");
		sb.append("body=").append(body);
		sb.append(", header=").append(header);
		sb.append('}');
		return sb.toString();
	}


	public void setHeader(Header header) {
		this.header = header;
	}

	public class Header {

		/**
		 * 请求ID
		 */
		private String reqId;

		/**
		 * 版本号
		 */
		private String version;

		/**
		 * 请求时间
		 */
		private String requestTime;

		/**
		 * 客户端ID
		 */
		private String appId;
		/**
		 * 认证类型  0->wss  1->sign -1 不验证
		 */
		private String authType;

		/**
		 * 用户名
		 */
		private String userName;

		/**
		 * 认证签名
		 */
		private String sign;

		public String getAuthType() {
			return authType;
		}

		public void setAuthType(String authType) {
			this.authType = authType;
		}

		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

		public String getRequestTime() {
			return requestTime;
		}

		public void setRequestTime(String requestTime) {
			this.requestTime = requestTime;
		}

		public String getSign() {
			return sign;
		}

		public void setSign(String sign) {
			this.sign = sign;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getReqId() {
			return reqId;
		}

		public void setReqId(String reqId) {
			this.reqId = reqId;
		}
	}

	public class Body {

		/**
		 * 文档类型
		 */
		@JacksonXmlProperty(isAttribute = true, localName = "dataFormat")
		private String docFormat;

		/**
		 * 服务名称
		 */
		private String serviceName;

		/**
		 * 数据源类别
		 */
		private String dataSourceType;

		/**
		 * 表名
		 */
		private String tableName;

		@JacksonXmlElementWrapper(localName = "dataList")
		@JacksonXmlProperty(localName = "data")
		private List<Map<String, String>> dataMapList;

		public List<Map<String, String>> getDataMapList() {
			return dataMapList;
		}

		public void setDataMapList(List<Map<String, String>> dataMapList) {
			this.dataMapList = dataMapList;
		}

		public String getDocFormat() {
			return docFormat;
		}

		public void setDocFormat(String docFormat) {
			this.docFormat = docFormat;
		}

		public String getServiceName() {
			return serviceName;
		}

		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}

		public String getDataSourceType() {
			return dataSourceType;
		}

		public void setDataSourceType(String dataSourceType) {
			this.dataSourceType = dataSourceType;
		}

		public String getTableName() {
			return tableName;
		}

		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
	}


}
