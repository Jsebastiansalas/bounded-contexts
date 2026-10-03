package com.demodd.domain.chat.priority.exception;

import com.demodd.domain.common.DomainException;

public class PriorityAlreadyExistsException extends DomainException {

    public PriorityAlreadyExistsException(String identifier) {
        super("Ya existe un registro de Priority con identificador: " + identifier);
    }
}
