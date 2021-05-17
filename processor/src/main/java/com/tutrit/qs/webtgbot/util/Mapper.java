package com.tutrit.qs.webtgbot.util;

import com.tutrit.qs.webtgbot.bean.StoredMessage;
import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.Update;

@UtilityClass
public class Mapper {
    public StoredMessage map(Update update) {
        var storedUpdate = new StoredMessage();
        try {
            storedUpdate.setUpdateId(update.getUpdateId());
        } catch (Exception ex) {

        }
        try {
            storedUpdate.setChatId(update.getMessage().getChatId());
        } catch (Exception ex) {

        }
        try {
            storedUpdate.setUserName(update.getMessage().getFrom().getUserName());
        } catch (Exception ex) {

        }
        try {
            storedUpdate.setText(update.getMessage().getText());
        } catch (Exception ex) {

        }
        return storedUpdate;
    }
}
