package com.tutrit.qs.webtgbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final TelegramBot telegramBot;
    private final ObjectMapper objectMapper;

    public String sendMessage(SendMessage sendMessage) {
        try {
            return objectMapper.writeValueAsString(telegramBot.execute(sendMessage));
        } catch (Exception e) {
            try {
                return objectMapper.writeValueAsString(e);
            } catch (Exception ex) {
                return ex.getMessage();
            }
        }

    }
}
