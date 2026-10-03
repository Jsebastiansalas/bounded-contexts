package com.demodd.domain.clinical.encountermodality.exception;

import com.demodd.domain.common.DomainException;

public class EncounterModalityAlreadyExistsException extends DomainException {

    public EncounterModalityAlreadyExistsException(String identifier) {
        super("Ya existe un registro de EncounterModality con identificador: " + identifier);
    }
}
