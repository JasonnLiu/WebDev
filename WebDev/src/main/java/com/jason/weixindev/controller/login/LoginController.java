package com.jason.weixindev.controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason.weixindev.message.resp.TextMessage;
import com.jason.weixindev.model.mybatis.login.LoginDAOImpl;
import com.jason.weixindev.service.inface.login.LoginService;
import com.jason.weixindev.util.MessageUtil;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "loginService")
	private LoginService loginService;

	@RequestMapping("/check")
	public String login(HttpServletRequest request, String username,
			String password) {

		if (loginService.check(username, password)) {
			HttpSession s = request.getSession();
			s.setAttribute("username", username);
			log.info("afd");
			return "index";
		} else {
			return "login";
		}

	}

	@RequestMapping("/register")
	public void register(HttpServletRequest req, HttpServletResponse resp) {

		String stdId = (String) req.getAttribute("stdId");
		String username = (String) req.getAttribute("username");
		Map map = (Map) req.getAttribute("map");

		log.info(stdId);
		log.info(username);
		String respContent;
		if (stdId == null || username == null) {
			respContent = "注册失败，请联系管理员";
		} else {
			// Map map = (Map) req.getAttribute("map");
			// String id = (String) map.get("FromUserName");
			String id = (String) map.get("FromUserName");
			if (loginService.register(stdId, username, id)) {
				respContent = "注册成功，您的注册学号是"+stdId+"您的姓名是"+username;
			} else {
				respContent = "注册失败，请联系管理员";
			}
		}

		String respXml = null;
		
		TextMessage tm = new TextMessage();
		tm.setFromUserName((String) map.get("ToUserName"));
		tm.setToUserName((String) map.get("FromUserName"));
		tm.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		tm.setCreateTime(new Date().getTime());
		tm.setContent(respContent);
		respXml = MessageUtil.message2xml(tm);
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(respXml);
		out.close();
		out = null;
		

	}
	
	@RequestMapping("/test/register")
	public void registertest(HttpServletRequest req, HttpServletResponse resp) {

		String stdId = "2013";
		String username = "中文";

		log.info(stdId);
		log.info(username);
		String respContent;
		if (stdId == null || username == null) {
			respContent = "注册失败，请联系管理员";
		} else {
			// Map map = (Map) req.getAttribute("map");
			// String id = (String) map.get("FromUserName");
			String id="id2013";
			if (loginService.register(stdId, username, id)) {
				respContent = "注册成功，您的注册学号是"+stdId;
			} else {
				respContent = "注册失败，请联系管理员";
			}
		}

		try {
			resp.getWriter().print(respContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public String toLoginPage() {
		return "login";
	}
}
