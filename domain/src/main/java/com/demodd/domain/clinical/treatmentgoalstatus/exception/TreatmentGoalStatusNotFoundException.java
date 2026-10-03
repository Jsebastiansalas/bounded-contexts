package com.demodd.domain.clinical.treatmentgoalstatus.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

public class TreatmentGoalStatusNotFoundException extends DomainException {

    public TreatmentGoalStatusNotFoundException(TreatmentGoalStatusId id) {
        super("No se encontro la entidad TreatmentGoalStatus con identificador: " + id.value());
    }

    public TreatmentGoalStatusNotFoundException(String message) {
        super(message);
    }
}
