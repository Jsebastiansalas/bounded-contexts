package com.demodd.domain.chat.messagetype.exception;

import com.demodd.domain.common.DomainException;

public class MessageTypeAlreadyExistsException extends DomainException {

    public MessageTypeAlreadyExistsException(String identifier) {
        super("Ya existe un registro de MessageType con identificador: " + identifier);
    }
}
