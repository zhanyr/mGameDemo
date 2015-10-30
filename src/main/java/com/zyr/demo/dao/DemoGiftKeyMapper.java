package com.zyr.demo.dao;

import com.zyr.demo.bean.DemoGiftKey;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DemoGiftKeyMapper {
	
	/**
	 * 添加礼包码
	 * @param demoGiftKey
	 * @return
	 */
	int addGiftKey(DemoGiftKey demoGiftKey);
	
	/**
	 * 标记被抢礼包
	 * @param id
	 * @return
	 */
	int updateGiftKeyById(int id);
	
	/**
	 * 取出一个礼包码
	 * @return
	 */
	DemoGiftKey getGiftKey();
}