package com.micmiu.common.xml;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 3/7/2016
 * Time: 10:14
 */
public class JacksonXmleExtMapper {

	private static Logger logger = LoggerFactory.getLogger(JacksonXmleExtMapper.class);

	public final static JacksonXmleExtMapper INSTANCE = new JacksonXmleExtMapper();

	private XmlMapper xmlMapper;

	public JacksonXmleExtMapper() {
		this(new XmlFactory());
	}

	public JacksonXmleExtMapper(XmlFactory factory) {
		xmlMapper = new XmlMapper(factory);
		xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	public String serXml(Object object) {
		if (null == object) {
			return null;
		}
		try {
			return xmlMapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.warn("write to xml string error:" + object, e);
			throw new RuntimeException(e.getLocalizedMessage());
		}
	}

	public <T> T deserXml(String xmlString, Class<T> clazz) {
		if (null == xmlString || xmlString.length() == 0) {
			return null;
		}

		try {
			return xmlMapper.readValue(xmlString, clazz);
		} catch (Exception e) {
			logger.warn("parse xml string error:" + xmlString, e);
			throw new RuntimeException(e.getLocalizedMessage());
		}
	}

	public XmlMapper getXmlMapper() {
		return xmlMapper;
	}
}
