package com.zyr.demo.util;

import org.junit.Test;

/**
 * 工具类测试类
 * @author zhanyr
 */
public class CommonUtilTest {
	
	@Test
	public void testGeneralGiftKey(){
		String generalGiftKey = CommonUtil.generalGiftKey();
		System.out.println(generalGiftKey);
	}
	
	@Test
	public void testGetMD5(){
		try {
			String md5Str = CommonUtil.getMD5("11111");
			System.out.println(md5Str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
