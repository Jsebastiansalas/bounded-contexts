package com.demodd.domain.clinical.assessmenttype.exception;

import com.demodd.domain.common.DomainException;

public class AssessmentTypeAlreadyExistsException extends DomainException {

    public AssessmentTypeAlreadyExistsException(String identifier) {
        super("Ya existe un registro de AssessmentType con identificador: " + identifier);
    }
}
