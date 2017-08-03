package com.micmiu.submarine;

import com.google.common.collect.Lists;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * Http client test
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/31/2017
 * Time: 10:25
 */
public class ClientHttpTest {

	public static void main(String[] args) {
		String reqData = MockDataUtils.mockXml4Request();
		try {
			HttpClient httpClient = new DefaultHttpClient();
			httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
			httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);

			HttpPost post = new HttpPost("http://localhost:8080/submarine/api/rest/v1/pushdata");
			//post.setHeader("Content-type", "application/json; charset=utf-8");
			post.setHeader(HTTP.CONTENT_ENCODING, HTTP.UTF_8);
			post.setHeader("Connection", "Close");

			List<NameValuePair> params = Lists.newArrayList();
			params.add(new BasicNameValuePair("compressType", "default"));
			params.add(new BasicNameValuePair("docFormat", "xml"));
			params.add(new BasicNameValuePair("reqData", reqData));
			post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));

			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			if (null != entity) {
				System.out.println("-------------------------------------------------------");
				System.out.println(EntityUtils.toString(entity));
				System.out.println("-------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
