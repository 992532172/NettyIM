package net.wehotel.zl.db.dal;

import java.util.List;

import net.wehotel.zl.api.domain.ChatMsgDomain;
import net.wehotel.zl.db.dao.ChatMsgInfoMapper;
import net.wehotel.zl.db.entity.ChatMsgInfo;
import net.wehotel.zl.db.entity.ChatMsgInfoExample;

import org.h2.store.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMsgDAL {
    private static int PAGE_SIZE = 20;

    @Autowired
    private ChatMsgInfoMapper chatMsgInfoMapper; 
    
    public void insert(ChatMsgInfo record){
        chatMsgInfoMapper.insert(record);
    }

    public void saveChatMsg(ChatMsgDomain domain){
        ChatMsgInfo record = new ChatMsgInfo();
        record.setMsgcontent(domain.getMsgcontent());
        record.setMsgtype(domain.getMsgtype());
        record.setReceiverid(domain.getReceiverid());
        record.setSenderid(domain.getSenderid());
        record.setSendtime(domain.getSendtime());
        record.setSpeakerid(domain.getSpeakerid());
        chatMsgInfoMapper.insert(record);
    }

    public List<ChatMsgInfo> findMsgByReceiver(String receiverid){
        ChatMsgInfoExample example = new ChatMsgInfoExample();
        example.createCriteria().andReceiveridEqualTo(receiverid);
        example.setOrderByClause("updatetime asc");
        return chatMsgInfoMapper.selectByExample(example );
    }

    public List<ChatMsgInfo> pageMsgByReceiver(String receiverid, Integer page){
        if(page == null || page <= 0){
            page = 1;
        }
        ChatMsgInfoExample example = new ChatMsgInfoExample();
        example.createCriteria().andReceiveridEqualTo(receiverid);
        example.setOrderByClause("updatetime asc");
        example.setLimitSize(PAGE_SIZE);
        example.setLimitStart(PAGE_SIZE * (page - 1));
        return chatMsgInfoMapper.selectByExample(example );
    }
}
