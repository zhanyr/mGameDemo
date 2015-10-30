package com.zyr.demo.dao;

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
	List<UserGift> getUserGiftByUserName(String userName);
	
	/**
	 * 添加所抢礼包
	 * @param demoUserGift
	 * @return
	 */
	int addUserGift(DemoUserGift demoUserGift);
}