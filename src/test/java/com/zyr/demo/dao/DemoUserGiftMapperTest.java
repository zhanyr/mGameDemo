package com.zyr.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.internal.matchers.StacktracePrintingMatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import com.zyr.demo.bean.DemoGiftKey;
import com.zyr.demo.bean.DemoUser;
import com.zyr.demo.bean.DemoUserGift;
import com.zyr.demo.bean.UserGift;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class DemoUserGiftMapperTest {
	
	@Autowired
	private DemoUserGiftMapper demoUserGiftMapper;
	
	@Test
	public void testAddUserGift(){
		DemoUserGift demoUserGift = new DemoUserGift();
		demoUserGift.setUserId(1);
		demoUserGift.setGiftId(1);
		demoUserGift.setGiftKey("ssdd");
		try{
			demoUserGiftMapper.addUserGift(demoUserGift);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testGetUserGiftByUserName(){
		try{
			List<UserGift> giftList = demoUserGiftMapper.getUserGiftByUserId(1);
			for (UserGift userGift : giftList) {
				System.out.println(userGift.getGiftName()+"   "+userGift.getGiftKey());
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testGetUserGiftByUIdAndGid(){
		try {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("userId", 1);
			map.put("giftId", 1);
			String giftKey = demoUserGiftMapper.getUserGiftByUIdAndGid(map);
			System.out.println(giftKey);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	

}
