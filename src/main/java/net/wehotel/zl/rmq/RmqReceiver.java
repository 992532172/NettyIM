package net.wehotel.zl.rmq;

import net.wehotel.zl.api.domain.ChatMsgDomain;
import net.wehotel.zl.service.dbservice.ChatMsgDBService;
import net.wehotel.zl.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liang.zhang on 2017/7/28.
 */
@Component
public class RmqReceiver {
    private Logger logger = LoggerFactory.getLogger(RmqReceiver.class);

    @Autowired
    private ChatMsgDBService chatMsgDBService;

    public void onMessage(String msg){
        try{
            ChatMsgDomain domain = GsonUtil.json2Obj(msg, ChatMsgDomain.class);
            chatMsgDBService.saveChatMsg(domain);
        } catch (Exception e) {
            logger.error("消息保存失败," + msg, e);
        }
    }
}
