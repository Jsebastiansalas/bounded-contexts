package com.demodd.domain.patient.professional.exception;

import com.demodd.domain.common.DomainException;

public class ProfessionalAlreadyExistsException extends DomainException {

    public ProfessionalAlreadyExistsException(String identifier) {
        super("Ya existe un registro de Professional con identificador: " + identifier);
    }
}
