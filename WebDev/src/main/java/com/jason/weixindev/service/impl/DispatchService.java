package com.jason.weixindev.service.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;

import com.jason.weixindev.util.MessageUtil;


public class DispatchService {

	public static String process(HttpServletRequest req) throws DocumentException, IOException{
		String respXml = null;

		Map<String, String> map = MessageUtil.parseReq(req);

		String MsgType = map.get("MsgType");
		if(MsgType.equals("зЂВс")){
			
		}
		
		return respXml;
	}
}
