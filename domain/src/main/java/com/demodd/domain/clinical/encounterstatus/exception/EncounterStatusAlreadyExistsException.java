package com.demodd.domain.clinical.encounterstatus.exception;

import com.demodd.domain.common.DomainException;

public class EncounterStatusAlreadyExistsException extends DomainException {

    public EncounterStatusAlreadyExistsException(String identifier) {
        super("Ya existe un registro de EncounterStatus con identificador: " + identifier);
    }
}
