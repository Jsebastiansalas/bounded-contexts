package com.demodd.domain.chat.chatmessage.exception;

import com.demodd.domain.common.DomainException;

public class ChatMessageAlreadyExistsException extends DomainException {

    public ChatMessageAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ChatMessage con identificador: " + identifier);
    }
}
