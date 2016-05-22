package com.jason.weixindev.service.impl.login;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jason.weixindev.model.inface.login.LoginDAO;
import com.jason.weixindev.service.inface.login.LoginService;

@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {

	@Resource(name = "loginDAO")
	private LoginDAO loginDAO;

	@Override
	public boolean check(String username, String password) {

		return loginDAO.check(username, password);
	}

	@Override
	public boolean register(String stdId, String username, String id) {
		if (loginDAO.register(stdId, username, id)) {
			return true;
		} else {
			return false;
		}
	}

}
