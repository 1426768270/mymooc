package com.mymooc.sso.util;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description 消息响应对象
 * @Author LQ
 * @CreateDate 2020/7/3 19:07
 * @Version 1.0
 */
public class ResMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    //响应编号
    private String respCode;
    //响应消息
    private String respMsg;
    //响应数据
    private Map<String,Object> respArgs;

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

    public Map<String, Object> getRespArgs() {
        return respArgs;
    }

    public void setRespArgs(Map<String, Object> respArgs) {
        this.respArgs = respArgs;
    }

    @Override
    public String toString() {
        return "ResMessage{" +
                "respCode='" + respCode + '\'' +
                ", respMsg='" + respMsg + '\'' +
                ", respArgs=" + respArgs +
                '}';
    }
}
