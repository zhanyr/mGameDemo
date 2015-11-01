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
	 * 用户名唯一性校验
	 * @param demoUser
	 * @return
	 */
	DemoUser checkUserName(String userName);
	
	/**
	 * 登录验证，验证用户名密码
	 * @param demoUser
	 * @return
	 */
	DemoUser validateLogin(DemoUser demoUser);
	
	/**
	 * 根据id查询用户信息
	 * @param userId 用户id
	 * @return
	 */
	DemoUser selectUserById(int userId);
	
	/**
	 * 修改用户信息
	 * @param demoUser
	 * @return
	 */
	int updateUser(DemoUser demoUser);
	
}