package net.wehotel.zl.service;

import io.netty.channel.Channel;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientStatusService {
    private Logger logger = LoggerFactory.getLogger(ClientStatusService.class);
    private ConcurrentMap<String, Channel> clientMap = new ConcurrentHashMap<String, Channel>();

    /**
     * 根据id获取客户端连接
     * 
     * @param id
     * @return
     */
    public Channel getClientById(String id) {
        return clientMap.get(id);
    }

    /**
     * 用户上线
     * 
     * @param userid
     * @param channel
     * @return
     * @throws Exception
     */
    public Channel addClient(String userid, Channel channel) throws Exception {
        if (channel == null || channel.remoteAddress() == null) {
            logger.warn("无法获取客户端ip");
        }
        Channel localchannel = clientMap.get(userid);
        if(localchannel == null){// 若账户未登录
            localchannel = clientMap.put(userid, channel);
        }
        return localchannel;
    }

    /**
     * 客户下线
     * 
     * @param channel
     */
    public void removeClient(Channel channel) {
        if (channel != null) {
            String key = getKey(channel);
            Channel result = clientMap.remove(key);
            if (result != null) {
                logger.debug("remove client {}:{}", key, result.remoteAddress());
            }
        }
    }

    public String getKey(Channel channel) {
        for (Entry<String, Channel> entrySet : clientMap.entrySet()) {
            if (channel.equals(entrySet.getValue())) {
                return entrySet.getKey();
            }
        }
        return null;
    }
}
