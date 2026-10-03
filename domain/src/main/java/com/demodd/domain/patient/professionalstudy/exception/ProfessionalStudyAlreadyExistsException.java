package com.demodd.domain.patient.professionalstudy.exception;

import com.demodd.domain.common.DomainException;

public class ProfessionalStudyAlreadyExistsException extends DomainException {

    public ProfessionalStudyAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ProfessionalStudy con identificador: " + identifier);
    }
}
