package com.zyr.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sun.net.www.content.image.gif;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.zyr.demo.bean.DemoGift;
import com.zyr.demo.bean.DemoGiftKey;
import com.zyr.demo.bean.DemoUserGift;
import com.zyr.demo.bean.UserGift;
import com.zyr.demo.cache.DemoRedis;
import com.zyr.demo.cache.RedisConst;
import com.zyr.demo.dao.DemoGiftKeyMapper;
import com.zyr.demo.dao.DemoGiftMapper;
import com.zyr.demo.dao.DemoUserGiftMapper;
import com.zyr.demo.service.GiftService;
import com.zyr.demo.util.CommonUtil;

@Service
public class GiftServiceImpl implements GiftService {
	
	private static Logger logger = Logger.getLogger(GiftServiceImpl.class);
	
	@Autowired
	DemoGiftMapper giftMapper;
	@Autowired
	DemoGiftKeyMapper giftKeyMapper;
	@Autowired
	DemoUserGiftMapper userGiftMapper;
	
	@Autowired
	DemoRedis demoRedis;

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

	@Override
	public int addGift(DemoGift gift) {
		//参数合法性判断
		if(null == gift){
			logger.info("添加礼包参数错误");
			return 1;
		}
		try {
			//添加礼包
			giftMapper.addGift(gift);
			//添加礼包码
			//生成礼包码
			List<DemoGiftKey> giftKeys = new ArrayList<DemoGiftKey>();
			for(int i=0;i<gift.getGiftCount();i++){
				DemoGiftKey giftKey = new DemoGiftKey();
				giftKey.setGiftId(gift.getId());
				giftKey.setGiftKey(CommonUtil.generalGiftKey());
				giftKeys.add(giftKey);
			}
			//礼包码插入数据库
			giftKeyMapper.addGiftKey(giftKeys);
			logger.info("添加礼包"+gift.getGiftName()+"成功");
			return 0;
		} catch (Exception e) {
			logger.error("添加礼包出现异常");
			logger.error("异常原因："+e);
			return 2;
		}
	}

	@Override
	@Transactional
	public String grabGift(int userId, int giftId) {
		if(userId <= 0 || giftId <= 0){
			logger.info("抢礼包参数错误");
			return "3";
		}
		//查询是否已经抢到
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		map.put("userId", userId);
		map.put("giftId", giftId);
		String giftKeyResult = userGiftMapper.getUserGiftByUIdAndGid(map);
		if(null != giftKeyResult){
			logger.info("已抢过礼包");
			return "1";
		}
		//生成随机数抢红包
		//未抢到，概率40%
		int random = Math.random()<0.4?0:1;
		//System.out.println(random);
		if( 0 == random){
			logger.info("未抢到礼包");
			return "2";
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
			
			//抢礼包成功,将用户礼包redis 缓存删除
			if(demoRedis.isExists(RedisConst.USER_GIFTS+userId))
				demoRedis.delKey(RedisConst.USER_GIFTS+userId);
			
			return giftKey.getGiftKey();
		}catch(Exception e){
			logger.error("出现异常，未抢到礼包");
			logger.error("失败原因："+e);
			return "3";
		}
	}

	@Override
	public List<UserGift> possessedGift(int userId) {
		if(userId <= 0){
			logger.info("查询用户拥有礼包列表参数错误");
			return null;
		}
		
		//查看redis
		//redis存在
		String keyString = RedisConst.USER_GIFTS+userId;
		String valueCache = demoRedis.get(keyString);
		if(null != valueCache){
			List<UserGift> userGiftsCache = JSONArray.parseArray(valueCache, UserGift.class);
			return userGiftsCache;
		}
		
		//redis不存在
		try{
			List<UserGift> userGifts = userGiftMapper.getUserGiftByUserId(userId);
			logger.info("查询用户拥有礼包成功");
			
			//存入redis
			if(userGifts.size()>0){
				String giftsValue = JSONArray.toJSONString(userGifts);
				demoRedis.setWithExpireTime(keyString, giftsValue,RedisConst.USER_GIFTS_TIME);
			}
			return userGifts;
		}catch(Exception e){
			logger.error("查询拥有的礼包失败");
			logger.error("失败原因："+e);
			return null;
		}
	}

}
