package net.wehotel.zl.service;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

@Service
public class ClientStatusService {
    private ConcurrentMap<String, Channel> clientMap = new ConcurrentHashMap<String, Channel>();

    public Channel addClient(String userid, Channel channel) {
        Channel localchannel = clientMap.get(userid);
        if (channel == null) {
            clientMap.put(userid, channel);
            localchannel = channel;
        }
        return localchannel;
    }
    
    public Channel getClientById(String id){
        return clientMap.get(id);
    }
}
