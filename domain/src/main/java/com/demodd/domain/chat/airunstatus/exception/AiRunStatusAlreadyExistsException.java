package com.demodd.domain.chat.airunstatus.exception;

import com.demodd.domain.common.DomainException;

public class AiRunStatusAlreadyExistsException extends DomainException {

    public AiRunStatusAlreadyExistsException(String identifier) {
        super("Ya existe un registro de AiRunStatus con identificador: " + identifier);
    }
}
