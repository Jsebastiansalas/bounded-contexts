package com.demodd.domain.clinical.clinicalrecordstatus.exception;

import com.demodd.domain.common.DomainException;

public class ClinicalRecordStatusAlreadyExistsException extends DomainException {

    public ClinicalRecordStatusAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ClinicalRecordStatus con identificador: " + identifier);
    }
}
