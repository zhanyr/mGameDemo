package com.zyr.demo.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import com.zyr.demo.bean.DemoGift;
import com.zyr.demo.bean.DemoUser;
import com.zyr.demo.bean.UserGift;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class GiftServiceTest {
	
	@Autowired
	private GiftService giftService;
	
	@Test
	public void testGetAllGift(){
		try{
			List<DemoGift> allGift = giftService.getAllGift();
			for (DemoGift demoGift : allGift) {
				System.out.println(demoGift.getGiftName());
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testGrabGift(){
		try{
			String giftKey = giftService.grabGift(1, 6);
			System.out.println(giftKey);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testPossessedGift(){
		try {
			List<UserGift> possessedGift = giftService.possessedGift(1);
			for (UserGift userGift : possessedGift) {
				System.out.println(userGift.getGiftName()+":"+userGift.getGiftKey());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testAddGift(){
		try {
			DemoGift gift = new DemoGift();
			gift.setGiftName("天龙八部");
			gift.setStartTime(new Date());
			gift.setEndTime(new Date());
			gift.setGiftCount(10);
			int addGift = giftService.addGift(gift);
			System.out.println(addGift);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
