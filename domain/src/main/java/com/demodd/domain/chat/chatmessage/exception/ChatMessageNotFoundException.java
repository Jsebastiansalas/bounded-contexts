package com.demodd.domain.chat.chatmessage.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.chatmessage.model.valueobject.ChatMessageId;

public class ChatMessageNotFoundException extends DomainException {

    public ChatMessageNotFoundException(ChatMessageId id) {
        super("No se encontro la entidad ChatMessage con identificador: " + id.value());
    }

    public ChatMessageNotFoundException(String message) {
        super(message);
    }
}
