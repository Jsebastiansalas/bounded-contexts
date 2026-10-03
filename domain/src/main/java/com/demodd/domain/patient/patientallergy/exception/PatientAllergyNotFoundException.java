package com.demodd.domain.patient.patientallergy.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.patient.patientallergy.model.valueobject.PatientAllergyId;

public class PatientAllergyNotFoundException extends DomainException {

    public PatientAllergyNotFoundException(PatientAllergyId id) {
        super("No se encontro la entidad PatientAllergy con identificador: " + id.value());
    }

    public PatientAllergyNotFoundException(String message) {
        super(message);
    }
}
