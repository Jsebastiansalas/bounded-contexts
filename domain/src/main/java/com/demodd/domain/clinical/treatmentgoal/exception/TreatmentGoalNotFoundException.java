package com.demodd.domain.clinical.treatmentgoal.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.treatmentgoal.model.valueobject.TreatmentGoalId;

public class TreatmentGoalNotFoundException extends DomainException {

    public TreatmentGoalNotFoundException(TreatmentGoalId id) {
        super("No se encontro la entidad TreatmentGoal con identificador: " + id.value());
    }

    public TreatmentGoalNotFoundException(String message) {
        super(message);
    }
}
