package net.wehotel.zl.api.domain;

public class ChatMsgDomain {
    private long id;// 消息流水号
    private String msgType;// 消息类型
    private String speakerId;// 发言者Id
    private String reveiverId;// 接收者Id(可以是群组id)
    private String msgContent;// 消息内容

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(String speakerId) {
        this.speakerId = speakerId;
    }

    public String getReveiverId() {
        return reveiverId;
    }

    public void setReveiverId(String reveiverId) {
        this.reveiverId = reveiverId;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    @Override
    public String toString() {
        return "{ \"id\" : \"" + id + "\", \"" + (msgType != null ? "msgType\" : \"" + msgType + "\", \"" : "")
                + (speakerId != null ? "speakerId\" : \"" + speakerId + "\", \"" : "")
                + (reveiverId != null ? "reveiverId\" : \"" + reveiverId + "\", \"" : "")
                + (msgContent != null ? "msgContent\" : \"" + msgContent : "") + "\"}";
    }
}
