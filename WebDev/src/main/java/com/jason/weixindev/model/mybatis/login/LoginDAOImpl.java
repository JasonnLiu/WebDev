package com.jason.weixindev.model.mybatis.login;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jason.weixindev.entity.comm.User;
import com.jason.weixindev.model.inface.login.LoginDAO;
import com.jason.weixindev.model.mybatis.BaseMyBatisDAO;

@Repository(value = "loginDAO")
public class LoginDAOImpl extends BaseMyBatisDAO implements LoginDAO {

	private static Logger log = LoggerFactory.getLogger(LoginDAOImpl.class);

	@Override
	public boolean check(String username, String password) {
		log.info("username :" + username);
		log.info("username :" + password);
		if (username == null || password == null)
			return false;
		log.info("loginDAO");
		SqlSession s = getSqlSession();
		User u = (User) s.selectOne(
				"com.jason.model.mybatis.login.selectUser", username);
		if (password.equals(u.getPassword())) {
			log.info("loginDAO true");
			return true;
		} else {
			log.info("loginDAO false");
			return false;
		}

	}
}
