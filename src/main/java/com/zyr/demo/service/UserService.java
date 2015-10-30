package com.zyr.demo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyr.demo.bean.DemoUser;

public interface UserService {
	
	/**
	 * 新用户注册
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String addUser(HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	/**
	 * 校验用户名是否已存在
	 * @param request
	 * @param response
	 * @return 0不存在 1已存在
	 * @throws Exception
	 */
	public int checkUserName(HttpServletRequest request, HttpServletResponse response)  throws Exception; 
	
	/**
	 * 修改用户资料
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String changeUserData(HttpServletRequest request, HttpServletResponse response)  throws Exception; 
	
	/**
	 * 查看用户个人信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public DemoUser getUserData(HttpServletRequest request, HttpServletResponse response)  throws Exception; 
}
