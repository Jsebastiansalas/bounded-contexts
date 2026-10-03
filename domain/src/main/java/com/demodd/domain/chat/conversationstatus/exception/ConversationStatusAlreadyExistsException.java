package com.demodd.domain.chat.conversationstatus.exception;

import com.demodd.domain.common.DomainException;

public class ConversationStatusAlreadyExistsException extends DomainException {

    public ConversationStatusAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ConversationStatus con identificador: " + identifier);
    }
}
