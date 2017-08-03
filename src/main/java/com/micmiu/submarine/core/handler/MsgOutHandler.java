package com.micmiu.submarine.core.handler;

import com.micmiu.common.json.Jackson2ExtMapper;
import com.micmiu.common.xml.JacksonXmleExtMapper;
import com.micmiu.submarine.core.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 消息输出处理器
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/29/2017
 * Time: 01:12
 */
public class MsgOutHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(MsgOutHandler.class);

	public static String outResponse(Response resp, String outType) {
		try {
			if ("json".equalsIgnoreCase(outType)) {
				return Jackson2ExtMapper.INSTANCE.serJson(resp);
			} else if ("xml".equalsIgnoreCase(outType)) {
				return JacksonXmleExtMapper.INSTANCE.serXml(resp);
			} else {
				return resp.toString();
			}
		} catch (Exception e) {
			LOGGER.error("error:", e);
			return e.getLocalizedMessage();
		}

	}
}
