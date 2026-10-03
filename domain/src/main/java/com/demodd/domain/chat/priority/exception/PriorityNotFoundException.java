package com.demodd.domain.chat.priority.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.priority.model.valueobject.PriorityId;

public class PriorityNotFoundException extends DomainException {

    public PriorityNotFoundException(PriorityId id) {
        super("No se encontro la entidad Priority con identificador: " + id.value());
    }

    public PriorityNotFoundException(String message) {
        super(message);
    }
}
