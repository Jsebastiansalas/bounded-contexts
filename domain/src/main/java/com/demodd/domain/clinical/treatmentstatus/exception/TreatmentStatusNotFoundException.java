package com.demodd.domain.clinical.treatmentstatus.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.treatmentstatus.model.valueobject.TreatmentStatusId;

public class TreatmentStatusNotFoundException extends DomainException {

    public TreatmentStatusNotFoundException(TreatmentStatusId id) {
        super("No se encontro la entidad TreatmentStatus con identificador: " + id.value());
    }

    public TreatmentStatusNotFoundException(String message) {
        super(message);
    }
}
