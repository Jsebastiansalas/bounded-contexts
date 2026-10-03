package com.demodd.domain.chat.chatconversationaisetting.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

public class ChatConversationAiSettingNotFoundException extends DomainException {

    public ChatConversationAiSettingNotFoundException(ChatConversationAiSettingId id) {
        super("No se encontro la entidad ChatConversationAiSetting con identificador: " + id.value());
    }

    public ChatConversationAiSettingNotFoundException(String message) {
        super(message);
    }
}
