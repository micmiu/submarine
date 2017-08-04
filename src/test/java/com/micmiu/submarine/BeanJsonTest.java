package com.micmiu.submarine;

import com.micmiu.common.json.Jackson2ExtMapper;
import com.micmiu.submarine.core.model.Request;
import com.micmiu.submarine.core.model.Response;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 2/29/2016
 * Time: 23:13
 */
public class BeanJsonTest {

	public static void main(String[] args) throws Exception {

		Response resp = MockDataUtils.mockResponSuccess();
		Request request = MockDataUtils.mockRequest("JSON", "upload");

		Jackson2ExtMapper mapper = new Jackson2ExtMapper();
		System.out.println(mapper.serJson(resp));

		System.out.println(mapper.serJson(request));


	}


}
