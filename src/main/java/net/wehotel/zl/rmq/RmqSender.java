package net.wehotel.zl.rmq;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liang.zhang on 2017/7/28.
 */
@Service
public class RmqSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息到queue,失败会重试,最多重试三次
     *
     * @param msg 消息json
     * @return
     */
    public boolean sendMsg(String msg){
        int times = 0;
        boolean success = false;
        while (!success && times < 3){
            try {
                amqpTemplate.convertAndSend(msg);
                success = true;
            } catch (Exception e) {
            }
            times ++;
        }
        return success;
    }
}
