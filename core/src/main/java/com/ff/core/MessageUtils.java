package com.ff.core;

import com.ff.core.message.MessageService;

/**
 * Created by 深谷 on 2017/8/29 上午9:52.
 */
public class MessageUtils {

    public static String sendMessage() {
        MessageService messageService = new MessageService();
        messageService.sendMessageVersionTwo();
        return messageService.sendMessage();
    }
}
