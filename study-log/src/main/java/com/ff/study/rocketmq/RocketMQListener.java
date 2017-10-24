package com.ff.study.rocketmq;

/**
 * Created by 深谷 on 2017/8/24 下午6:31.
 */
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * Created by lance on 2017/2/10.
 */
public class RocketMQListener implements MessageListenerConcurrently {


    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//        System.out.println("get data from rocketMQ:" + msgs);
        System.out.println("do consumeMessage====wsf");
        for (MessageExt message : msgs) {

            String msg = new String(message.getBody());
            System.out.println("msg data from rocketMQ:" + msg);
        }

        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
