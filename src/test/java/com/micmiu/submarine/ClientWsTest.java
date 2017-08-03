package com.micmiu.submarine;

import com.micmiu.submarine.core.api.DataExchangeService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * webservice client test
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/31/2017
 * Time: 10:25
 */
public class ClientWsTest {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean soapFactoryBean = new JaxWsProxyFactoryBean();
		soapFactoryBean.setAddress("http://localhost:8080/submarine/api/ws/dataExchangeSimpleService");
		soapFactoryBean.setServiceClass(DataExchangeService.class);
		Object o = soapFactoryBean.create();
		DataExchangeService service = (DataExchangeService) o;

		String reqData = MockDataUtils.mockXml4Request();
		String result = service.pushData("default", "xml", reqData);
		System.out.println("-------------------------------------------------------");
		System.out.println(result);
		System.out.println("-------------------------------------------------------");
	}
}
