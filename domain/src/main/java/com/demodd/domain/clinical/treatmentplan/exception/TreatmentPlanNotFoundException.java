package com.demodd.domain.clinical.treatmentplan.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.treatmentplan.model.valueobject.TreatmentPlanId;

public class TreatmentPlanNotFoundException extends DomainException {

    public TreatmentPlanNotFoundException(TreatmentPlanId id) {
        super("No se encontro la entidad TreatmentPlan con identificador: " + id.value());
    }

    public TreatmentPlanNotFoundException(String message) {
        super(message);
    }
}
