package com.demodd.domain.patient.patientcontact.exception;

import com.demodd.domain.common.DomainException;

public class PatientContactAlreadyExistsException extends DomainException {

    public PatientContactAlreadyExistsException(String identifier) {
        super("Ya existe un registro de PatientContact con identificador: " + identifier);
    }
}
