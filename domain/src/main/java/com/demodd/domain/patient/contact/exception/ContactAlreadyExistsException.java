package com.demodd.domain.patient.contact.exception;

import com.demodd.domain.common.DomainException;

public class ContactAlreadyExistsException extends DomainException {

    public ContactAlreadyExistsException(String identifier) {
        super("Ya existe un registro de Contact con identificador: " + identifier);
    }
}
