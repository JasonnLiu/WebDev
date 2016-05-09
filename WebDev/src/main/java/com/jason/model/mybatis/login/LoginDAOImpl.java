package com.jason.model.mybatis.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jason.controller.HelloController;
import com.jason.model.inface.login.LoginDAO;

@Repository(value="loginDAO")
public class LoginDAOImpl implements LoginDAO{
	
	
	private static Logger log = LoggerFactory.getLogger(LoginDAOImpl.class);

	@Override
	public boolean check(String username, String password) {
		
		
		
		log.info("loginDAO");
		return true;
	}

}
