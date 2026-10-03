package com.demodd.domain.patient.patientcontact.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.patient.patientcontact.model.valueobject.PatientContactId;

public class PatientContactNotFoundException extends DomainException {

    public PatientContactNotFoundException(PatientContactId id) {
        super("No se encontro la entidad PatientContact con identificador: " + id.value());
    }

    public PatientContactNotFoundException(String message) {
        super(message);
    }
}
