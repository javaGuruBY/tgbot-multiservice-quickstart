package com.tutrit.qs.webtgbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutrit.qs.webtgbot.proxy.BotProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final BotProxy botProxy;

    public String sendMessage(String text, Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        return botProxy.sendMessage(sendMessage);
    }
}
