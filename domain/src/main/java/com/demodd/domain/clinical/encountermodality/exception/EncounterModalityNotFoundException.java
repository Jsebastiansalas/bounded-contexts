package com.demodd.domain.clinical.encountermodality.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.encountermodality.model.valueobject.EncounterModalityId;

public class EncounterModalityNotFoundException extends DomainException {

    public EncounterModalityNotFoundException(EncounterModalityId id) {
        super("No se encontro la entidad EncounterModality con identificador: " + id.value());
    }

    public EncounterModalityNotFoundException(String message) {
        super(message);
    }
}
