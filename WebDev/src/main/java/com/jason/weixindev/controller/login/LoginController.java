package com.jason.weixindev.controller.login;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason.weixindev.model.mybatis.login.LoginDAOImpl;
import com.jason.weixindev.service.inface.login.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static Logger log = LoggerFactory.getLogger(LoginController.class);

	@Resource(name="loginService")
	private LoginService loginService;

	@RequestMapping("/check")
	public String login(HttpServletRequest request,String username,String password) {
		
		if (loginService.check(username, password)) {
			HttpSession s = request.getSession();
			s.setAttribute("username", username);
			return "index";
		} else {
			return "login";
		}

	}

	public String toLoginPage() {
		return "login";
	}
}
