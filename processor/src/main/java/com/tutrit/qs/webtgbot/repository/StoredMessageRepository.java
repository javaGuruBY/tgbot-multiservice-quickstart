package com.tutrit.qs.webtgbot.repository;

import com.tutrit.qs.webtgbot.bean.StoredMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StoredMessageRepository extends JpaRepository<StoredMessage, Integer> {
    StoredMessage findFirstByChatId(Long chatId);
    StoredMessage findFirstByUserName(String userName);
    Iterable<StoredMessage> findAllByChatId(Long chatId);
    Iterable<StoredMessage> findAllByUserName(String userName);
}
