package com.demodd.domain.chat.chatescalation.exception;

import com.demodd.domain.common.DomainException;

public class ChatEscalationAlreadyExistsException extends DomainException {

    public ChatEscalationAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ChatEscalation con identificador: " + identifier);
    }
}
