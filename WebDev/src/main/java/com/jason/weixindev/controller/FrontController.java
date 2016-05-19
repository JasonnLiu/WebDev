package com.jason.weixindev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jason.weixindev.service.impl.DispatchService;
import com.jason.weixindev.util.SignUtil;

@Controller
public class FrontController {
	private static Logger log = LoggerFactory.getLogger(FrontController.class);

	@RequestMapping(value = "/weixin", method = RequestMethod.GET)
	public void verify(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");

		PrintWriter out = resp.getWriter();
		if (SignUtil.checkSign(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;
	}

	@RequestMapping(value = "/weixin", method = RequestMethod.POST)
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, DocumentException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");

		PrintWriter out = resp.getWriter();
		if (SignUtil.checkSign(signature, timestamp, nonce)) {

			String respXml = DispatchService.process(req);
			out.print(respXml);

		}
		out.close();
		out = null;
	}
}
