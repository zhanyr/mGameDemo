package com.zyr.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.net.www.content.image.gif;

import com.zyr.demo.bean.DemoGift;
import com.zyr.demo.bean.DemoGiftKey;
import com.zyr.demo.bean.DemoUserGift;
import com.zyr.demo.bean.UserGift;
import com.zyr.demo.dao.DemoGiftKeyMapper;
import com.zyr.demo.dao.DemoGiftMapper;
import com.zyr.demo.dao.DemoUserGiftMapper;
import com.zyr.demo.service.GiftService;

@Service
public class GiftServiceImpl implements GiftService {
	
	private static Logger logger = Logger.getLogger(GiftServiceImpl.class);
	
	@Autowired
	DemoGiftMapper giftMapper;
	@Autowired
	DemoGiftKeyMapper giftKeyMapper;
	@Autowired
	DemoUserGiftMapper userGiftMapper;

	@Override
	public List<DemoGift> getAllGift() {
		//获取全部礼包
		List<DemoGift> gifts = new ArrayList<DemoGift>();
		try{
			List<DemoGift> allGift = giftMapper.selectAllGift();
			gifts = allGift;
			logger.info("查询全部游戏礼包");
		}catch(Exception e){
			logger.error("查询全部游戏礼包错误");
			logger.error("错误原因："+e);
		}
		return gifts;
	}

	//TODO
	@Override
	public int addGift(DemoGift gift) {
		//参数合法性判断
		if(null == gift){
			logger.info("添加礼包参数错误");
			return 2;
		}
//		//添加礼包
//		giftMapper.addGift(gift);
//		//添加礼包码
//		
//		try{
//			int addGiftResult = giftMapper.addGift(gift);
//			if(addGiftResult <= 0){
//				logger.info("添加礼包"+gift.getGiftName()+"失败！");
//				return 1;
//			}
//			logger.info("添加礼包"+gift.getGiftName()+"成功！");
//			return 0;
//		}catch(Exception e){
//			logger.error("添加礼包失败");
//			logger.error("失败原因："+e);
//			return 2;
//		}
		return 0;
	}

	//TODO
	@Override
	public String grabGift(int userId, int giftId) {
		if(userId <= 0 || giftId <= 0){
			logger.info("抢礼包参数错误");
			return null;
		}
		//生成随机数抢红包
		//未抢到，概率40%
		int random = Math.random()<0.4?0:1;
		System.out.println(random);
		if( 0 == random){
			logger.info("未抢到礼包");
			return null;
		}
		//抢到，概率60%
		try{
			//从key中取出一个礼包码，并将对应礼包码状态置为已被抢
			DemoGiftKey giftKey = giftKeyMapper.getGiftKey(giftId);
			giftKeyMapper.updateGiftKeyById(giftKey.getId());
			//剩余数量减1
			giftMapper.updateGiftCount(giftKey.getGiftId());
			//将抢到的礼包码存入用户拥有礼包
			DemoUserGift userGift = new DemoUserGift();
			userGift.setGiftId(giftKey.getGiftId());
			userGift.setUserId(userId);
			userGift.setGiftKey(giftKey.getGiftKey());
			userGiftMapper.addUserGift(userGift);
			logger.info("用户id为"+userId+"抢礼包"+giftId+"成功");
			return giftKey.getGiftKey();
		}catch(Exception e){
			logger.error("未抢到礼包");
			logger.error("失败原因："+e);
			return null;
		}
	}

	@Override
	public List<UserGift> possessedGift(int userId) {
		if(userId <= 0){
			logger.info("查询用户拥有礼包列表参数错误");
			return null;
		}
		try{
			List<UserGift> userGifts = userGiftMapper.getUserGiftByUserId(userId);
			logger.info("查询用户拥有礼包成功");
			return userGifts;
		}catch(Exception e){
			logger.error("查询拥有的礼包失败");
			logger.error("失败原因："+e);
			return null;
		}
	}

}
