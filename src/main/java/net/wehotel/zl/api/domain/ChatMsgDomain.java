package net.wehotel.zl.api.domain;

import java.util.Date;

public class ChatMsgDomain {
    public static final String SIMPLE_CHAT = "1";
    public static final String GROUP_CHAT = "2";

    private int id;// 消息流水号
    private Date sendtime;// 服务器接收到消息的时间
    private String msgtype;// 消息类型
    private String speakerid;// 发言者Id
    private String senderid;
    private String receiverid;// 接收者Id(可以是群组id)
    private String msgcontent;// 消息内容

    public String getMsgcontent() {
        return msgcontent;
    }

    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getSpeakerid() {
        return speakerid;
    }

    public void setSpeakerid(String speakerid) {
        this.speakerid = speakerid;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid;
    }

    @Override
    public String toString() {
        return "{ \"id\" : \"" + id + "\", \"" + (sendtime != null ? "sendtime\" : \"" + sendtime + "\", \"" : "")
                + (msgtype != null ? "msgtype\" : \"" + msgtype + "\", \"" : "")
                + (speakerid != null ? "speakerid\" : \"" + speakerid + "\", \"" : "")
                + (senderid != null ? "senderid\" : \"" + senderid + "\", \"" : "")
                + (receiverid != null ? "receiverid\" : \"" + receiverid + "\", \"" : "")
                + (msgcontent != null ? "msgcontent\" : \"" + msgcontent : "") + "\"}";
    }
}
