package com.demodd.domain.clinical.treatmentgoalstatus.exception;

import com.demodd.domain.common.DomainException;

public class TreatmentGoalStatusAlreadyExistsException extends DomainException {

    public TreatmentGoalStatusAlreadyExistsException(String identifier) {
        super("Ya existe un registro de TreatmentGoalStatus con identificador: " + identifier);
    }
}
