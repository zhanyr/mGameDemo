package com.zyr.demo.util;

import java.util.UUID;

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
}
