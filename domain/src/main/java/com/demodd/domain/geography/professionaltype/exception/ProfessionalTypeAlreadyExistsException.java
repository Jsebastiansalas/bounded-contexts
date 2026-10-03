package com.demodd.domain.geography.professionaltype.exception;

import com.demodd.domain.common.DomainException;

public class ProfessionalTypeAlreadyExistsException extends DomainException {

    public ProfessionalTypeAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ProfessionalType con identificador: " + identifier);
    }
}
