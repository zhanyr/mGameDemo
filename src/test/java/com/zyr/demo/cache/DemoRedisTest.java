package com.zyr.demo.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class DemoRedisTest {
	@Autowired
	DemoRedis demoRedis;
	
	@Test
	public void testSet(){
		String result = demoRedis.set("name", "zhanyr11");
		System.out.println(result);
	}
	
	@Test
	public void testGet(){
		String name = demoRedis.get("name");
		System.out.println(name);
	}
	
	@Test
	public void testIsExists(){
		System.out.println(demoRedis.isExists("name"));
	}
	
	@Test
	public void testSetExpire(){
		System.out.println(demoRedis.get("name"));
		demoRedis.setExpire("name", 2);
		try {
			Thread.sleep(3000);
			System.out.println(demoRedis.get("name"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void test(){
		if(demoRedis.isExists("name")){
			System.out.println("删除前");
			System.out.println(demoRedis.get("name"));
			System.out.println(demoRedis.delKey("name"));
			System.out.println("删除后");
			System.out.println(demoRedis.get("name"));
		}
		demoRedis.set("name", "zhanyr");
		System.out.println("添加");
		System.out.println(demoRedis.get("name"));
		
			
		
	}
}
