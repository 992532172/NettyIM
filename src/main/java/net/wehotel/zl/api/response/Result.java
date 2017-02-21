package net.wehotel.zl.api.response;

import java.io.Serializable;

public class Result implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final String SUCCESS_CODE = "0";
    
    private String code = "0";// 状态码 0 成功, -1 失败
    private String msg;// 消息详情

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void setValue(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{ \"" + (code != null ? "code\" : \"" + code + "\", \"" : "") + (msg != null ? "msg\" : \"" + msg : "") + "\"}";
    }
}
