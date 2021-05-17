package com.tutrit.qs.webtgbot.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.telegram.telegrambots.meta.api.objects.Update;

@FeignClient(name = "PROCESSOR")
public interface ProcessorProxy {

    @PostMapping("/onUpdate")
    void sendUpdate(Update update);
}
