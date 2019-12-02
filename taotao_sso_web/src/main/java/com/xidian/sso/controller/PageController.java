package com.xidian.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 展示登录和注册页面的Controller
 * <p>Title: PageController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class PageController {

	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}
	@RequestMapping("/page/login")
	public String showLogin(String url, Model model) {
		model.addAttribute("redirect", url);//在页面，用js实现
		return "login";
	}
}
