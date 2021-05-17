package com.tutrit.qs.webtgbot.controller;

import com.tutrit.qs.webtgbot.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/send")
    public String sendMessage(@RequestBody SendMessage sendMessage) {
        return messageService.sendMessage(sendMessage);
    }
}


