package com.demodd.domain.clinical.medicationroute.exception;

import com.demodd.domain.common.DomainException;

public class MedicationRouteAlreadyExistsException extends DomainException {

    public MedicationRouteAlreadyExistsException(String identifier) {
        super("Ya existe un registro de MedicationRoute con identificador: " + identifier);
    }
}
