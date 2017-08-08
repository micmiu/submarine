Submarine (DataEchange for java)

## Describe
data exchange quick application for java, receive data only use log output for demo.

 ------

## Featuren
 * protocol: restful 、webservice 
 * data format : XML、Json 
 
 ------
 
## Data Format Demo:

 * XML Demo:

		<Request>
            <Header>
                <version>1.0</version>
                <requestTime>2012-06-07 09:28:30</requestTime>
                <appId>ios_9</appId>
                <userName>micmiu</userName>
                <sign>3c87defa80cbee6ddc12a1d12e9a8f04</sign>
            </Header>
            <Body DocFormat="XML">
                <serviceName>upload</serviceName>
                <dataSourceType>demo</dataSourceType>
                <tableName>t_blog</tableName>
                <dataList>
                    <data>
                        <ROWKEY>123456</ROWKEY>
                        <AUTHOR>Michael</AUTHOR>
                        <URL>micmiu.com</URL>
                    </data>
                </dataList>
            </Body>
        </Request>
 * Json Demo:

		{
            "header": {
                "reqId": null, 
                "version": "1.0", 
                "requestTime": "2016-03-03 00:30:30", 
                "appId": "client_ios9", 
                "authType": null, 
                "userName": "micmiu", 
                "sign": "test"
            }, 
            "body": {
                "docFormat": "JSON", 
                "serviceName": "upload", 
                "dataSourceType": "demo", 
                "tableName": "t_blog", 
                "dataMapList": [
                    {
                        "ROWKEY": "10001", 
                        "LASTMT": "2016-03-02 10:18:10", 
                        "CITYCODE ": "200000", 
                        "NAME ": "孙悟空", 
                        "SEX": "男", 
                        "URL": "micmiu.com"
                    }, 
                    {
                        "ROWKEY": "10002", 
                        "LASTMT": "2016-03-02 10:18:10", 
                        "CITYCODE ": "200000", 
                        "NAME ": "孙小美", 
                        "BIRTH": "201x-xx-xx", 
                        "SEX": "女"
                    }
                ]
            }
        }

 --------
 		
 

