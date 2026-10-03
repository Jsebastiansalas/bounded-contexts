package com.demodd.domain.patient.phonecontact.exception;

import com.demodd.domain.common.DomainException;

public class PhoneContactAlreadyExistsException extends DomainException {

    public PhoneContactAlreadyExistsException(String identifier) {
        super("Ya existe un registro de PhoneContact con identificador: " + identifier);
    }
}
