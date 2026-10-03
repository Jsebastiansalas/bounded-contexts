package com.demodd.domain.patient.patient.exception;

import com.demodd.domain.common.DomainException;

public class PatientAlreadyExistsException extends DomainException {

    public PatientAlreadyExistsException(String identifier) {
        super("Ya existe un registro de Patient con identificador: " + identifier);
    }
}
