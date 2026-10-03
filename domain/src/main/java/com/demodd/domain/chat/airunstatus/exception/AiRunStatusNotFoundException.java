package com.demodd.domain.chat.airunstatus.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.airunstatus.model.valueobject.AiRunStatusId;

public class AiRunStatusNotFoundException extends DomainException {

    public AiRunStatusNotFoundException(AiRunStatusId id) {
        super("No se encontro la entidad AiRunStatus con identificador: " + id.value());
    }

    public AiRunStatusNotFoundException(String message) {
        super(message);
    }
}
