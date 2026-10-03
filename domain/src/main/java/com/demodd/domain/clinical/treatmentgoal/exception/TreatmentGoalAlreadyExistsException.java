package com.demodd.domain.clinical.treatmentgoal.exception;

import com.demodd.domain.common.DomainException;

public class TreatmentGoalAlreadyExistsException extends DomainException {

    public TreatmentGoalAlreadyExistsException(String identifier) {
        super("Ya existe un registro de TreatmentGoal con identificador: " + identifier);
    }
}
