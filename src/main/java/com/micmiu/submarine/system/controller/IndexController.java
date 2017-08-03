package com.micmiu.submarine.system.controller;

import com.micmiu.submarine.system.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 首页
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Controller
public class IndexController {

	private static final String PREFIX = Constant.VIEW_PREFIX;

	@RequestMapping("/index.do")
	public String index(HttpServletRequest req) {
		return PREFIX + "index";
	}


	@RequestMapping("/home.do")
	public String home(HttpServletRequest req) {
		return PREFIX + "home";
	}

}
