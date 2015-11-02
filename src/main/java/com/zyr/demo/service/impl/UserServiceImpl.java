package com.zyr.demo.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyr.demo.bean.DemoUser;
import com.zyr.demo.dao.DemoUserMapper;
import com.zyr.demo.service.UserService;
import com.zyr.demo.util.CommonUtil;

@Service
public class UserServiceImpl implements UserService {
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	DemoUserMapper demoUserMapper;

	@Override
	public int addUser(DemoUser user) {
		//判读参数合法性
		if(null == user){
			logger.debug("注册用户参数错误");
			return 2;
		}
		//插入数据库
		try{
			user.setPassword(CommonUtil.getMD5(user.getPassword()));
			int addUserResult = demoUserMapper.addUser(user);
			if(addUserResult <= 0){
				logger.info("用户"+user.getUserName()+"注册失败!");
				return 1;
			}
			logger.info("用户"+user.getUserName()+"注册成功!");
		}catch(Exception e){
			logger.error("用户"+user.getUserName()+"注册失败！");
			logger.error("失败原因:"+e);
			return 2;
		}
		return 0;
	}

	@Override
	public DemoUser login(String userName, String password) {
		DemoUser demoUserResult = new DemoUser();
		//判读参数合法性
		if(null == userName || "".equals(userName.trim()) || null == password || "".equals(password.trim())){
			logger.debug("登录参数错误");
			return null;
		}
		
		//登录验证
		try{
			//封装
			DemoUser user = new DemoUser();
			user.setUserName(userName);
			user.setPassword(CommonUtil.getMD5(password));
			DemoUser userResult = demoUserMapper.validateLogin(user);
			if(null == userResult){
				logger.info("用户"+userName+"登录失败");
				return null;
			}
			logger.info("用户"+userName+"登录成功");
			demoUserResult = userResult;
		}catch(Exception e){
			logger.error("用户"+userName+"登录失败！");
			logger.error("失败原因:"+e);
			return null;
		}
		return demoUserResult;
	}

	@Override
	public int checkUserName(String userName) {
		//判读用户名是否合法
		if(null == userName || "".equals(userName.trim())){
			logger.debug("用户名唯一性验证参数错误");
			return 2;
		}
		//验证用户是否已存在
		try{
			DemoUser userResult = demoUserMapper.checkUserName(userName);
			if(null == userResult){
				logger.info("注册验证，用户名"+userName+"不存在");
				return 0;
			}else{
				logger.info("注册验证，用户名"+userName+"已存在");
				return 1;
			}
		}catch(Exception e){
			logger.error("用户"+userName+"唯一性验证失败！");
			logger.error("失败原因:"+e);
			return 2;
		}
	}

	@Override
	public int changeUserData(DemoUser user) {
		//判读参数合法性
		if(null == user){
			logger.debug("修改用户个人信息参数错误");
			return 2;
		}
		//修改用户信息
		try{
			user.setPassword(CommonUtil.getMD5(user.getPassword()));
			int updateUserResult = demoUserMapper.updateUser(user);
			if(updateUserResult <= 0){
				logger.info("用户"+user.getUserName()+"修改个人信息失败");
				return 1;
			}
			logger.info("用户"+user.getUserName()+"修改个人信息成功");
		}catch(Exception e){
			logger.error("用户"+user.getUserName()+"修改个人信息失败");
			logger.error("失败原因:"+e);
			return 2;
		}
		return 0;
	}

	@Override
	public DemoUser getUserData(int userId) {
		DemoUser demoUserResult = new DemoUser();
		if(userId <= 0){
			logger.debug("查询用户个人信息参数不合法");
			return null;
		}
		try{
			DemoUser user = demoUserMapper.selectUserById(userId);
			if(null == user){
				logger.info("未查到用户信息");
				return null;
			}
			logger.info("查到用户信息"+user.getUserName());
			demoUserResult = user;
		}catch(Exception e){
			logger.error("查询用户"+userId+"个人信息失败");
			logger.error("失败原因:"+e);
			return null;
		}
		return demoUserResult;
	}

}
