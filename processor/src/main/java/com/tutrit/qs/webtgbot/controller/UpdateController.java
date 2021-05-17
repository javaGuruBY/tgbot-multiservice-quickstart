package com.tutrit.qs.webtgbot.controller;

import com.tutrit.qs.webtgbot.proxy.BotProxy;
import com.tutrit.qs.webtgbot.service.RequestDispatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UpdateController {
    private final ServerProperties serverProperties;
    private final BotProxy botProxy;
    private final RequestDispatcher requestDispatcher;

    @PostMapping("/onUpdate")
    public void onUpdateReceived(@RequestBody Update update) {
        requestDispatcher.dispatch(update);
    }
}
