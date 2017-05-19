package com.iflytek.bbs.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iflytek.bbs.po.User;
import com.iflytek.bbs.service.UserService;

public class TestUserServiceImpl {
	private UserService service = new UserServiceImpl();
	@Test
	public void add() {
		User u = new User();
		u.setName("王子");
		u.setEmail("123123@qq.com");
		u.setPassword("123123");
		service.add(u);
		
	}
	@Test
	public void getUser(){
		User user = service.getUser("1220442883@qq.com", "123456");
		assertNotEquals(null,user);
		
		
	}
	@Test
	public void getUserPassword(){
		User password = service.getUserPassword(5);
		assertNotEquals(null, password);
	}
	@Test
	public void updatePassword(){
		service.updatePassword(5,"961123");
		
	}

}
