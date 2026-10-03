package com.demodd.domain.patient.patient.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.patient.patient.model.valueobject.PatientId;

public class PatientNotFoundException extends DomainException {

    public PatientNotFoundException(PatientId id) {
        super("No se encontro la entidad Patient con identificador: " + id.value());
    }

    public PatientNotFoundException(String message) {
        super(message);
    }
}
