package com.jason.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/hello")
public class HelloController {
	
	private static Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(){
		log.info("hello method2");
		return "hello";
	}
}
