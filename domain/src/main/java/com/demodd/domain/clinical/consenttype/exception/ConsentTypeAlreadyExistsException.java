package com.demodd.domain.clinical.consenttype.exception;

import com.demodd.domain.common.DomainException;

public class ConsentTypeAlreadyExistsException extends DomainException {

    public ConsentTypeAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ConsentType con identificador: " + identifier);
    }
}
