package com.zyr.demo.dao;

import java.util.ArrayList;
import java.util.List;

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
		giftKey.setGiftId(1);
		giftKey.setGiftKey("454");
		List<DemoGiftKey> giftKeys = new ArrayList<DemoGiftKey>();
		giftKeys.add(giftKey);
		try{
			demoGiftKeyMapper.addGiftKey(giftKeys);
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
			DemoGiftKey giftKey = demoGiftKeyMapper.getGiftKey(23);
			System.out.println(giftKey.getGiftKey());
		}catch(Exception e){
			System.out.println(e);
		}
	}
	

}
