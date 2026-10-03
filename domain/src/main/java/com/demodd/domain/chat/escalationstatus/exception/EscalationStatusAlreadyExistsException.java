package com.demodd.domain.chat.escalationstatus.exception;

import com.demodd.domain.common.DomainException;

public class EscalationStatusAlreadyExistsException extends DomainException {

    public EscalationStatusAlreadyExistsException(String identifier) {
        super("Ya existe un registro de EscalationStatus con identificador: " + identifier);
    }
}
