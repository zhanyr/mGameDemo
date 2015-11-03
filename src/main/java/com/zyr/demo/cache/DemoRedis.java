package com.zyr.demo.cache;

public interface DemoRedis {
    /**添加
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value);
    /**
     * 获取
     * @param key
     * @return
     */
    public String get(String key);
    
    /**
     * 删除
     * @param key
     * @return
     */
    public Long delKey(String key);
    /**
     * 设置过期时间
     * @param key
     * @param seconds
     * @return
     */
    public boolean setExpire(String key, int seconds);
	
	/**
	 * 查询某个key是否存在
	 * @param key
	 * @return
	 */
	public boolean isExists(String key);
    /**
     * 有过期时间的设值
     * @param key  
     * @param value
     * @param seconds  过期时间
     */
    public boolean setWithExpireTime(String key, String value,int seconds);
}
