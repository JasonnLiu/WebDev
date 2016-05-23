package com.jason.weixindev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jason.weixindev.service.impl.DispatchService;
import com.jason.weixindev.util.MessageUtil;
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
		log.info("verify");
		PrintWriter out = resp.getWriter();
		if (SignUtil.checkSign(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;
	}

	@RequestMapping(value = "/weixin", method = RequestMethod.POST)
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, DocumentException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");

		PrintWriter out = resp.getWriter();
		log.info("weixinpost");
		if (SignUtil.checkSign(signature, timestamp, nonce)) {
			dispatch(req, resp);
			// String respXml = dispatch(req,resp);
			// out.print(respXml);

		}
		out.close();
		out = null;
	}

	@RequestMapping("/dis")
	public void test(HttpServletRequest req, HttpServletResponse resp) {
		log.info("test");
		dispatch(req, resp);
	}

	private void dispatch(HttpServletRequest req, HttpServletResponse resp) {
		Map<String, String> map = null;
		try {
			map = MessageUtil.parseReq(req);
		} catch (DocumentException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String MsgType = null;
		if (map != null) {
			MsgType = map.get("MsgType");
			req.setAttribute("map", map);
		} else {
			log.error("can't resolve the req");
			return;
		}

		if (MsgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
			String msgContent = map.get("Content");
			log.info("weixindispatch");
			log.info(msgContent);
			try {
				if (msgContent.startsWith("зЂВс")) {
					String stdId = msgContent.substring(2);
					req.setAttribute("stdId", stdId);
					req.getRequestDispatcher("/login/register").forward(req, resp);
				}else{
					log.info("can't zhuce");
				}
				
				
				
				
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
