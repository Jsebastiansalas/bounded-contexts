package com.demodd.domain.chat.chatconversationaisetting.exception;

import com.demodd.domain.common.DomainException;

public class ChatConversationAiSettingAlreadyExistsException extends DomainException {

    public ChatConversationAiSettingAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ChatConversationAiSetting con identificador: " + identifier);
    }
}
