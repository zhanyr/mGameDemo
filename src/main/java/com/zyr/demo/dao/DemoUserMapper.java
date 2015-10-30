package com.zyr.demo.dao;

import com.zyr.demo.bean.DemoUser;

public interface DemoUserMapper {
	
	/**
	 * 添加新用户
	 * @param demoUser
	 * @return
	 */
	int addUser(DemoUser demoUser);
	
	/**
	 * 查询用户信息，包括用户名唯一性校验、账号密码校验
	 * @param demoUser
	 * @return
	 */
	DemoUser selectUser(DemoUser demoUser);
	
	/**
	 * 修改用户信息
	 * @param demoUser
	 * @return
	 */
	int updateUser(DemoUser demoUser);
	
}