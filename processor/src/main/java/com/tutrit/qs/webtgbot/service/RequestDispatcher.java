package com.tutrit.qs.webtgbot.service;

import com.tutrit.qs.webtgbot.repository.StoredMessageRepository;
import com.tutrit.qs.webtgbot.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class RequestDispatcher {
    private final MessageService messageService;

    private final StoredMessageRepository storedMessageRepository;

    public void dispatch(Update update) {
        storedMessageRepository.save(Mapper.map(update));
        allCommands(update);
    }

    private void allCommands(Update update) {
        messageService.sendMessage(update.getMessage().getText(), update.getMessage().getChatId());
    }
}
