package com.demodd.domain.clinical.treatmentplan.exception;

import com.demodd.domain.common.DomainException;

public class TreatmentPlanAlreadyExistsException extends DomainException {

    public TreatmentPlanAlreadyExistsException(String identifier) {
        super("Ya existe un registro de TreatmentPlan con identificador: " + identifier);
    }
}
