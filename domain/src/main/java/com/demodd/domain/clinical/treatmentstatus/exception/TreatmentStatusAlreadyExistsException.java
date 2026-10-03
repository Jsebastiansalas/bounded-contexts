package com.demodd.domain.clinical.treatmentstatus.exception;

import com.demodd.domain.common.DomainException;

public class TreatmentStatusAlreadyExistsException extends DomainException {

    public TreatmentStatusAlreadyExistsException(String identifier) {
        super("Ya existe un registro de TreatmentStatus con identificador: " + identifier);
    }
}
