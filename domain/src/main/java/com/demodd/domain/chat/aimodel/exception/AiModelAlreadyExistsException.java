package com.demodd.domain.chat.aimodel.exception;

import com.demodd.domain.common.DomainException;

public class AiModelAlreadyExistsException extends DomainException {

    public AiModelAlreadyExistsException(String identifier) {
        super("Ya existe un registro de AiModel con identificador: " + identifier);
    }
}
