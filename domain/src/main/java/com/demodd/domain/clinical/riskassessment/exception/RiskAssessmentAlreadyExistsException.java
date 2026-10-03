package com.demodd.domain.clinical.riskassessment.exception;

import com.demodd.domain.common.DomainException;

public class RiskAssessmentAlreadyExistsException extends DomainException {

    public RiskAssessmentAlreadyExistsException(String identifier) {
        super("Ya existe un registro de RiskAssessment con identificador: " + identifier);
    }
}
