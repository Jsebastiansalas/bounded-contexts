package com.demodd.domain.clinical.assessmenttype.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.assessmenttype.model.valueobject.AssessmentTypeId;

public class AssessmentTypeNotFoundException extends DomainException {

    public AssessmentTypeNotFoundException(AssessmentTypeId id) {
        super("No se encontro la entidad AssessmentType con identificador: " + id.value());
    }

    public AssessmentTypeNotFoundException(String message) {
        super(message);
    }
}
