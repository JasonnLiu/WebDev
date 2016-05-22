package com.jason.weixindev.model.inface.login;

public interface LoginDAO {
	public boolean check(String username,String password);

	

	public boolean register(String stdId, String username, String id);
}
