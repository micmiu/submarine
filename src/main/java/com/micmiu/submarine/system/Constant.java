package com.micmiu.submarine.system;

/**
 * 系统管理常量
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class Constant {

	public static final String UI_NAME = "bootstrap";
	//tiles -> "."  sitemesh -> "/"
	public static final String LAYOUT_SPLIT = "/";
	//tiles -> "."  sitemesh -> "_"
	public static final String VIEW_PAGE_SPLIT = "_";
	public static final String VIEW_PREFIX = UI_NAME + LAYOUT_SPLIT;
	
	public static final String TRANSFER_TUNNEL_STATUS_ENABLE_ID = "1";
	public static final String TRANSFER_TUNNEL_STATUS_ENABLE_TEXT = "启用";
	
	public static final String TRANSFER_TUNNEL_STATUS_DISABLE_ID = "0";
    public static final String TRANSFER_TUNNEL_STATUS_DISABLE_TEXT = "停用";
}
