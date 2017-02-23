package net.wehotel.zl.api.request;
/**
 * netty基础请求类
 * 
 * @author Liang.Zhang
 * @date 2017年2月17日 下午5:12:17
 */
public class BaseNettyMsg {
    public static String IDLE_RQ = "IDLE";
    
    private String rqType;// 请求类型
    private String msgContent;// 请求内容

    public String getRqType() {
        return rqType;
    }

    public void setRqType(String rqType) {
        this.rqType = rqType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    @Override
    public String toString() {
        return "{ \"" + (rqType != null ? "rqType\" : \"" + rqType + "\", \"" : "") + (msgContent != null ? "msgContent\" : \"" + msgContent : "")
                + "\"}";
    }
}
