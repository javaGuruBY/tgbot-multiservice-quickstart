package com.tutrit.qs.webtgbot.controller;

import com.tutrit.qs.webtgbot.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/send")
    public String sendMessage(final String text, final Long chatId) {
        return messageService.sendMessage(text, chatId);
    }
}
