package com.demodd.domain.clinical.encountertype.exception;

import com.demodd.domain.common.DomainException;

public class EncounterTypeAlreadyExistsException extends DomainException {

    public EncounterTypeAlreadyExistsException(String identifier) {
        super("Ya existe un registro de EncounterType con identificador: " + identifier);
    }
}
