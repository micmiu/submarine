package com.micmiu.submarine.core.controller;

import com.micmiu.submarine.core.service.CacheManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 8/1/2017
 * Time: 23:15
 */
@Controller
@RequestMapping("/api/cache/")
public class CacheManageController {

	@Autowired
	private CacheManageService cacheManageService;

	@RequestMapping(value = "/reload.do")
	@ResponseBody
	public String show(String page) {
		cacheManageService.reload();
		return "OK";
	}
}
