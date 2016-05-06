package com.jason.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/hello")
public class HelloController {
	
	private static Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(Map<String,Object> modeldd,HttpServletRequest request , String addr2){
		log.info("hello method2");
		modeldd.put("user", "jason");
		modeldd.put("addr", addr2);
		System.out.println(addr2);
		//String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
		return "hello";
	}
}
