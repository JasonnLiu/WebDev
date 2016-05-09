package com.jason.service.impl.login;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jason.model.inface.login.LoginDAO;
import com.jason.service.inface.login.LoginService;

@Service(value="loginService")
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="loginDAO")
	private LoginDAO loginDAO;

	@Override
	public boolean check(String username,String password) {
		
		return loginDAO.check(username, password);
	}

}
