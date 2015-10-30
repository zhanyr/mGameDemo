package com.zyr.demo.dao;

import org.junit.Test;
import org.junit.internal.matchers.StacktracePrintingMatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import com.zyr.demo.bean.DemoGiftKey;
import com.zyr.demo.bean.DemoUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class DemoGiftKeyMapperTest {
	
	@Autowired
	private DemoGiftKeyMapper demoGiftKeyMapper;
	
	@Test
	public void testAddGiftKey(){
		DemoGiftKey giftKey = new DemoGiftKey();
		giftKey.setGiftId(23);
		giftKey.setGiftKey("asdfgh");
		try{
			demoGiftKeyMapper.addGiftKey(giftKey);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testUpdateGiftKeyById(){
		try{
			demoGiftKeyMapper.updateGiftKeyById(1);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testGetGiftKey(){
		try{
			DemoGiftKey giftKey = demoGiftKeyMapper.getGiftKey();
			System.out.println(giftKey.getGiftKey());
		}catch(Exception e){
			System.out.println(e);
		}
	}
	

}
