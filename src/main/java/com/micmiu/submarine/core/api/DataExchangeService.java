package com.micmiu.submarine.core.api;

import javax.jws.WebService;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/28/2017
 * Time: 00:16
 */
@WebService(name = "DataExchange")
public interface DataExchangeService {

	String pushSimpleData(String reqData);

	String pushData(String compressType, String docFormat, String reqData);

	String querySimpleData(String reqData);

	String queryData(String compressType, String docFormat, String reqData);


}
