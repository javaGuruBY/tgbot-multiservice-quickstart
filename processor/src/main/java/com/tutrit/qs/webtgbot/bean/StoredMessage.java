package com.tutrit.qs.webtgbot.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class StoredMessage {
    @Id
    private Integer updateId;
    private Long chatId;
    private String userName;
    private String text;
}
