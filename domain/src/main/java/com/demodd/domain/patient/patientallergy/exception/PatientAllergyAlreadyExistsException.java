package com.demodd.domain.patient.patientallergy.exception;

import com.demodd.domain.common.DomainException;

public class PatientAllergyAlreadyExistsException extends DomainException {

    public PatientAllergyAlreadyExistsException(String identifier) {
        super("Ya existe un registro de PatientAllergy con identificador: " + identifier);
    }
}
