package com.zyr.demo.service;

import com.zyr.demo.bean.DemoUser;

public interface UserService {
	
	/**
	 * 新用户注册
	 * @param user
	 * @return 0成功 1失败 2其他
	 */
	public int addUser(DemoUser user);
	
	/**
	 * 用户登录验证
	 * @param userName 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public DemoUser login(String userName,String password);
	
	/**
	 * 校验用户名是否已存在
	 * @param userName 用户名
	 * @return 0不存在，用户名可用  1已存在，用户名不可用 2其他
	 */
	public int checkUserName(String userName); 
	
	/**
	 * 修改用户资料
	 * @param user
	 * @return 0修改成功 1修改失败 2其他
	 */
	public int changeUserData(DemoUser user); 
	
	/**
	 * 查看用户个人信息
	 * @param user
	 * @return 用户信息
	 */
	public DemoUser getUserData(int userId); 
}
