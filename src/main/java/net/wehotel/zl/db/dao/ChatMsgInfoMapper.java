package net.wehotel.zl.db.dao;

import java.util.List;
import net.wehotel.zl.db.entity.ChatMsgInfo;
import net.wehotel.zl.db.entity.ChatMsgInfoExample;
import org.apache.ibatis.annotations.Param;

public interface ChatMsgInfoMapper {
    int countByExample(ChatMsgInfoExample example);

    int deleteByExample(ChatMsgInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChatMsgInfo record);

    int insertSelective(ChatMsgInfo record);

    List<ChatMsgInfo> selectByExampleWithBLOBs(ChatMsgInfoExample example);

    List<ChatMsgInfo> selectByExample(ChatMsgInfoExample example);

    ChatMsgInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChatMsgInfo record, @Param("example") ChatMsgInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ChatMsgInfo record, @Param("example") ChatMsgInfoExample example);

    int updateByExample(@Param("record") ChatMsgInfo record, @Param("example") ChatMsgInfoExample example);

    int updateByPrimaryKeySelective(ChatMsgInfo record);

    int updateByPrimaryKeyWithBLOBs(ChatMsgInfo record);

    int updateByPrimaryKey(ChatMsgInfo record);
}