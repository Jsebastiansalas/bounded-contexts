package com.demodd.domain.clinical.clinicalrecord.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.clinicalrecord.model.valueobject.ClinicalRecordId;

public class ClinicalRecordNotFoundException extends DomainException {

    public ClinicalRecordNotFoundException(ClinicalRecordId id) {
        super("No se encontro la entidad ClinicalRecord con identificador: " + id.value());
    }

    public ClinicalRecordNotFoundException(String message) {
        super(message);
    }
}
