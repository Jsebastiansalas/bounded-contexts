package com.demodd.domain.clinical.clinicalrecordstatus.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;

public class ClinicalRecordStatusNotFoundException extends DomainException {

    public ClinicalRecordStatusNotFoundException(ClinicalRecordStatusId id) {
        super("No se encontro la entidad ClinicalRecordStatus con identificador: " + id.value());
    }

    public ClinicalRecordStatusNotFoundException(String message) {
        super(message);
    }
}
