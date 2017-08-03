package com.micmiu.submarine;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.micmiu.common.xml.JacksonXmleExtMapper;
import com.micmiu.submarine.core.model.Request;
import com.micmiu.submarine.core.model.Response;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 2/29/2016
 * Time: 23:13
 */
public class BeanXmlTest {

	public static void main(String[] args) throws Exception {

		Response resp = new Response();
		resp.setCode(Response.CODE_SUCCESS);
		resp.setMessage("success");
		XmlMapper xml = new XmlMapper();
		xml.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		System.out.println(xml.writeValueAsString(resp));

		System.out.println(JacksonXmleExtMapper.INSTANCE.serXml(resp));

	}

	public static void testXmlFile2Bean() throws Exception {
		XmlMapper xml = new XmlMapper();
		xml.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Request request = xml.readValue(new File("/Users/micmiu/Downloads/data.error.xml"), Request.class);
		System.out.println(request);
	}

	private static void testXmlRead() {
		try {
			SAXReader sr = new SAXReader();//获取读取xml的对象。
			Document doc = sr.read("/Users/micmiu/Downloads/tmp/5f00715038e04c10beca1ee834b16145.xml");

			String strxml = doc.asXML();
			System.out.println(strxml);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test1() throws Exception {
		XmlMapper xml = new XmlMapper();
		xml.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		System.out.println(xml.writeValueAsString(MockDataUtils.mockRequest4Upload()));

		System.out.println(xml.writeValueAsString(MockDataUtils.mockResponFail()));


		Request request = xml.readValue(MockDataUtils.mockXml4Request(), Request.class);
		System.out.println(request);

		request = xml.readValue(MockDataUtils.mockDataXmlError(), Request.class);
		System.out.println(request);
	}
}
