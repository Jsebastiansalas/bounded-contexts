package com.demodd.domain.patient.emailcontact.exception;

import com.demodd.domain.common.DomainException;

public class EmailContactAlreadyExistsException extends DomainException {

    public EmailContactAlreadyExistsException(String identifier) {
        super("Ya existe un registro de EmailContact con identificador: " + identifier);
    }
}
