package com.demodd.domain.clinical.clinicalrecord.exception;

import com.demodd.domain.common.DomainException;

public class ClinicalRecordAlreadyExistsException extends DomainException {

    public ClinicalRecordAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ClinicalRecord con identificador: " + identifier);
    }
}
