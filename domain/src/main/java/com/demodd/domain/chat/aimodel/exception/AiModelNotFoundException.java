package com.demodd.domain.chat.aimodel.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.aimodel.model.valueobject.AiModelId;

public class AiModelNotFoundException extends DomainException {

    public AiModelNotFoundException(AiModelId id) {
        super("No se encontro la entidad AiModel con identificador: " + id.value());
    }

    public AiModelNotFoundException(String message) {
        super(message);
    }
}
