package com.demodd.domain.chat.chatconversation.exception;

import com.demodd.domain.common.DomainException;

public class ChatConversationAlreadyExistsException extends DomainException {

    public ChatConversationAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ChatConversation con identificador: " + identifier);
    }
}
