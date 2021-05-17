package com.tutrit.qs.webtgbot.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@FeignClient(name = "bot")
public interface BotProxy {

    @PostMapping("/send")
    String sendMessage(SendMessage sendMessage);
}
