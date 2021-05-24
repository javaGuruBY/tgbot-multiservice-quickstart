package com.tutrit.qs.webtgbot.controller;

import com.tutrit.qs.webtgbot.service.MessageService;
import com.tutrit.qs.webtgbot.service.TelegramBot;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final TelegramBot telegramBot;

    @PostMapping("/send")
    public String sendMessage(@RequestBody SendMessage sendMessage) {
        return messageService.sendMessage(sendMessage);
    }

    @PostMapping("/update")
    public void sendUpdate(@RequestBody Update update) {
        telegramBot.onUpdateReceived(update);
    }
}


