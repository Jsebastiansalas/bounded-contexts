package com.demodd.domain.chat.chatconversation.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.chatconversation.model.valueobject.ChatConversationId;

public class ChatConversationNotFoundException extends DomainException {

    public ChatConversationNotFoundException(ChatConversationId id) {
        super("No se encontro la entidad ChatConversation con identificador: " + id.value());
    }

    public ChatConversationNotFoundException(String message) {
        super(message);
    }
}
