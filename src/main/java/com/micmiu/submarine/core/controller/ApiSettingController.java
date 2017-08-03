package com.micmiu.submarine.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 2/18/2016
 * Time: 16:25
 */
@Controller
@RequestMapping("/api/setting/")
public class ApiSettingController {

	@RequestMapping(value = "/show.do")
	public String show(String page) {
		return "/bootstrap/demo/" + page;
	}
}
