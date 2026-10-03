package com.demodd.domain.clinical.encounter.exception;

import com.demodd.domain.common.DomainException;

public class EncounterAlreadyExistsException extends DomainException {

    public EncounterAlreadyExistsException(String identifier) {
        super("Ya existe un registro de Encounter con identificador: " + identifier);
    }
}
