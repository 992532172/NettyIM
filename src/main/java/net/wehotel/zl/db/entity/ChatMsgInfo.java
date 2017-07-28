package net.wehotel.zl.db.entity;

import java.io.Serializable;
import java.util.Date;

public class ChatMsgInfo implements Serializable {
    //
    private Integer id;

    //
    private String msgtype;

    //
    private String speakerid;

    //
    private String senderid;

    //
    private String receiverid;

    //
    private Date sendtime;

    //
    private String msgcontent;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype == null ? null : msgtype.trim();
    }

    public String getSpeakerid() {
        return speakerid;
    }

    public void setSpeakerid(String speakerid) {
        this.speakerid = speakerid == null ? null : speakerid.trim();
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid == null ? null : senderid.trim();
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid == null ? null : receiverid.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getMsgcontent() {
        return msgcontent;
    }

    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent == null ? null : msgcontent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", msgtype=").append(msgtype);
        sb.append(", speakerid=").append(speakerid);
        sb.append(", senderid=").append(senderid);
        sb.append(", receiverid=").append(receiverid);
        sb.append(", sendtime=").append(sendtime);
        sb.append(", msgcontent=").append(msgcontent);
        sb.append("]");
        return sb.toString();
    }
}