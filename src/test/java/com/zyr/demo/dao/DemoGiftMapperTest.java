package com.zyr.demo.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.internal.matchers.StacktracePrintingMatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import com.zyr.demo.bean.DemoGift;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class DemoGiftMapperTest {
	
	@Autowired
	private DemoGiftMapper demoGiftMapper;
	
	@Test
	public void testAddGift(){
		DemoGift gift = new DemoGift();
		gift.setGiftName("大话西游4");
		gift.setGiftCount(0);
		gift.setStartTime(new Date());
		gift.setEndTime(new Date());
		try{
			demoGiftMapper.addGift(gift);
			System.out.println(gift.getId());
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testGetAllGift(){
		try{
			List<DemoGift> gifts = demoGiftMapper.selectAllGift();
			for (DemoGift gift : gifts) {
				System.out.println(gift.getGiftName());
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testUpdateGiftCount(){
		try{
			int updateGiftCount = demoGiftMapper.updateGiftCount(1);
			System.out.println(updateGiftCount);
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
