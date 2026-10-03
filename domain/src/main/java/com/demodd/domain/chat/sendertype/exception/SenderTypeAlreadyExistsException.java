package com.demodd.domain.chat.sendertype.exception;

import com.demodd.domain.common.DomainException;

public class SenderTypeAlreadyExistsException extends DomainException {

    public SenderTypeAlreadyExistsException(String identifier) {
        super("Ya existe un registro de SenderType con identificador: " + identifier);
    }
}
