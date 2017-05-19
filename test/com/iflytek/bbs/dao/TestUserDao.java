package com.iflytek.bbs.dao;

import static org.junit.Assert.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iflytek.bbs.po.User;

public class TestUserDao {
	private static SqlSession session;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//读取mybaties配置文件
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		
		//打开session,后期用于获取接口对象
		session = sessionFactory.openSession();
	}

	@Test
	public void testAdd() {
		
		UserDao dao = session.getMapper(UserDao.class);
		
		User u = new User();
		u.setName("王子");
		u.setEmail("001@qq.com");
		u.setPassword("123");
		
		dao.add(u);
		session.commit();
	}
	@Test
	public void testUpdatePassword() {
		
		UserDao dao = session.getMapper(UserDao.class);
		
		dao.updatePassword(9, "1234");
		//增删改需要提交
		session.commit();
	}
	@Test
	public void testGetUser(){
		UserDao dao = session.getMapper(UserDao.class);
		User u = dao.getUser("121@qq.com", "123");
		System.out.println(u.getId());
		assertNotEquals(u, null);
	}
	@Test
	public void testGetUserPassword(){
		UserDao dao = session.getMapper(UserDao.class);
		User password = dao.getUserPassword(1);
		System.out.println(password);
		assertNotEquals(password, null);
	}


}
