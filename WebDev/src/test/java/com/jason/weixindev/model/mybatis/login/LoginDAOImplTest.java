package com.jason.weixindev.model.mybatis.login;

import static org.junit.Assert.*;

import java.io.InputStream;



import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class LoginDAOImplTest {

	@Test
	public void test() {
		LoginDAOImpl im = new LoginDAOImpl();
		String conf = "mybatis_config.xml";
		InputStream is = LoginDAOImpl.class.getClassLoader().getResourceAsStream(conf);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		if(sqlSessionFactory == null){
			System.out.println("aa");
		}
		Environment e = sqlSessionFactory.getConfiguration().getEnvironment();
		
		im.setSqlSessionFactory(sqlSessionFactory);
		im.register("20", "ja", "30");
	}

}
