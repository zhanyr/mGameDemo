package com.zyr.demo.bean.vo;

/**
 * Message Controller层返回信息
 *
 * @author zhanyr
 * @date 2015/11/1
 */
public class Message {
    /**
     * 结果： 0 成功； 1 失败
     */
    private int result;

    /**
     * 操作内容
     */
    private String content;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
