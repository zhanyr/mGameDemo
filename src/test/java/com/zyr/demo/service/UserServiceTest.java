package com.zyr.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import com.zyr.demo.bean.DemoUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testAddUser(){
		DemoUser user = new DemoUser();
		user.setRole("0");
		user.setPassword("1111122");
		user.setUserName("zhanyaru");
		user.setScore(0);
		user.setEnabled("0");
		int addUser = userService.addUser(user);
		System.out.println(addUser);
	}
	
	@Test
	public void testLogin(){
		DemoUser loginResult = userService.login("zhanyr", "11122");
		System.out.println(loginResult);
	}
	
	@Test
	public void testCheckUserName(){
		int checkUserName1 = userService.checkUserName("zhanyaru");
		int checkUserName2 = userService.checkUserName("zhyr");
		System.out.println(checkUserName1);
		System.out.println(checkUserName2);
	}
	
	@Test
	public void testChangeUserData(){
		DemoUser user = new DemoUser();
		user.setId(2);
		user.setPassword("22222");
		user.setUserName("zhanyaru");
		int changeUserData = userService.changeUserData(user);
		System.out.println(changeUserData);
	}
}
