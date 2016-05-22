package com.jason.weixindev.service.inface.login;

public interface LoginService {
	public boolean check(String username,String password);

	public boolean register(String stdId, String username, String id);

}
