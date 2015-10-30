package com.zyr.demo.dao;

import org.junit.Test;
import org.junit.internal.matchers.StacktracePrintingMatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import com.zyr.demo.bean.DemoUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class DemoUserMapperTest {
	
	@Autowired
	private DemoUserMapper demoUserMapper;
	
	@Test
	public void testAddUser(){
		DemoUser user = new DemoUser();
		user.setRole("1");
		user.setPassword("11111");
		user.setUserName("zhanyr");
		user.setScore(0);
		user.setEnabled("0");
		try{
			demoUserMapper.addUser(user);
		}catch(Exception e){
			System.out.println(e+"");
		}
		
	}
	
	@Test
	public void testSelectUser(){
		DemoUser user = new DemoUser();
		//user.setPassword("11111");
		user.setUserName("zhanyr");
		try{
			DemoUser demoUser = demoUserMapper.selectUser(user);
			System.out.println(demoUser.getUserName());
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testUpdateUser(){
		DemoUser user = new DemoUser();
		user.setUserName("zhanyr");
		user.setPassword("11122");
		user.setPhone("12345566");
		user.setSex("0");
		try{
			demoUserMapper.updateUser(user);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
