package com.zyr.demo.dao;

import java.util.HashMap;
import java.util.List;

import com.zyr.demo.bean.DemoUserGift;
import com.zyr.demo.bean.UserGift;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DemoUserGiftMapper {
	
	/**
	 * 用户查询所有抢到的礼包
	 * @return
	 */
	List<UserGift> getUserGiftByUserId(int userId);
	
	/**
	 * 添加所抢礼包
	 * @param demoUserGift
	 * @return
	 */
	int addUserGift(DemoUserGift demoUserGift);
	
	/**
	 * 查询用户是否已经抢过礼包
	 * @param map
	 * @return
	 */
	String getUserGiftByUIdAndGid(HashMap<String, Integer> map);
}