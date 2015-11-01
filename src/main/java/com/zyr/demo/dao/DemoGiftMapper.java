package com.zyr.demo.dao;

import java.util.List;

import com.zyr.demo.bean.DemoGift;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DemoGiftMapper {
	
	/**
	 * 添加游戏礼包
	 * @param demoGift
	 * @return
	 */
	int addGift(DemoGift demoGift);
	
	/**
	 * 查询所有游戏礼包
	 * @return
	 */
	List<DemoGift> selectAllGift();
	
	/**
	 * 修改礼包剩余数量
	 * @param giftId 礼包id
	 * @return
	 */
	int updateGiftCount(int giftId);

}