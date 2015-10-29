package com.zyr.demo.dao;

import org.junit.Test;
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
		demoUserMapper.addUser(user);
	}
	
}
