package com.zyr.demo.util;

import java.security.MessageDigest;
import java.util.UUID;

import sun.misc.BASE64Encoder;

public class CommonUtil {
	 /**
     * 随机生成生成礼包兑换码
     * @return 32位UUID字符串
     */
    public static String generalGiftKey(){
        String giftKey = UUID.randomUUID().toString();
        giftKey = giftKey.replaceAll("-","");
        return giftKey;
    }
    
    public static String getMD5(String str) throws Exception{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
	    //加密后的字符串
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
}
