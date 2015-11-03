package com.zyr.demo.cache.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.zyr.demo.cache.DemoRedis;

@Service
public class DemoRedisImpl implements DemoRedis {

	Logger logger = Logger.getLogger(DemoRedisImpl.class);
	
	@Autowired
	JedisPool jedisPool;
	@Override
	public String set(String key, String value) {
		Jedis jedis = null;
		String result = null;
		try {
			jedis = jedisPool.getResource();
			if(null != jedis){
				result = jedis.set(key, value);
			}else{
				logger.error("redis 连接失败");
			}
		} catch (Exception e) {
			logger.error("redis set 异常");
			logger.error("异常原因"+e);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return result;
	}

	@Override
	public String get(String key) {
		Jedis jedis = null;
		String result = null;
		try {
			jedis = jedisPool.getResource();
			if(null != jedis){
				result = jedis.get(key);
			}else{
				logger.error("redis 连接失败");
			}
		} catch (Exception e) {
			logger.error("redis get 异常");
			logger.error("异常原因"+e);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return result;
	}

	@Override
	public boolean isExists(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.exists(key);
		} catch (Exception e) {
			logger.error("redis isExists 异常");
			logger.error("异常原因"+e);
			return false;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	
	@Override
	public boolean setExpire(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long r = jedis.expire(key, seconds);
			if (r > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.error("redis setExpire 异常");
			logger.error("异常原因"+e);
			return false;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean setWithExpireTime(String key, String value, int seconds) {
		this.set(key, value);
    	return this.setExpire(key, seconds);
	}

	@Override
	public Long delKey(String key) {
		Jedis jedis = null;
        try {
        	jedis = jedisPool.getResource();
            return jedis.del(key);
        } catch (Exception e) {
            logger.error("redis delKey 异常");
            logger.error("异常原因"+e);
            return null;
        }finally{
			jedisPool.returnResource(jedis);
		}
	}

}
