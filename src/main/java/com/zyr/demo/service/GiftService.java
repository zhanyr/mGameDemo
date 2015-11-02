package com.zyr.demo.service;

import java.util.List;

import com.zyr.demo.bean.DemoGift;
import com.zyr.demo.bean.DemoGiftKey;
import com.zyr.demo.bean.UserGift;

public interface GiftService {
	/**
	 * 用户查看全部游戏礼包列表
	 * @return 游戏礼包列表
	 */
	public List<DemoGift> getAllGift();
	
	/**
	 * 添加礼包类型
	 * @param gift礼包信息
	 * @return 0成功 1失败 2其他
	 */
	public int addGift(DemoGift gift);
	
	/**
	 * 用户抢礼包
	 * @param userId 用户id
	 * @param giftId 礼包id
	 * @return 1 已抢过该礼包  2未抢到再接再励   3出现异常 
	 */
	public String grabGift(int userId,int giftId);
	
	/**
	 * 用户拥有的全部礼包
	 * @param userId 用户id
	 * @return 用户拥有礼包列表
	 */
	public List<UserGift> possessedGift(int userId);
	
	
}
