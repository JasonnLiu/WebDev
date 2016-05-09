package com.jason.controller.login;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason.service.inface.login.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource(name="loginService")
	private LoginService loginService;

	@RequestMapping("/check")
	public String login(Map m,HttpServletRequest request) {
		String username = (String) m.get("username");
		String password = (String) m.get("password");
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
