package com.mymooc.sso.util;

import java.io.Serializable;

/**
 * @Description     消息响应对象
 * @Author       LQ
 * @CreateDate   2020/7/3 19:07
 * @Version      1.0
 */
public class ResMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    //响应编号
    private String respCode;
    //响应消息
    private String respMsg;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
}
