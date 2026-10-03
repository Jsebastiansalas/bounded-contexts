package com.demodd.domain.clinical.riskassessment.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.riskassessment.model.valueobject.RiskAssessmentId;

public class RiskAssessmentNotFoundException extends DomainException {

    public RiskAssessmentNotFoundException(RiskAssessmentId id) {
        super("No se encontro la entidad RiskAssessment con identificador: " + id.value());
    }

    public RiskAssessmentNotFoundException(String message) {
        super(message);
    }
}
