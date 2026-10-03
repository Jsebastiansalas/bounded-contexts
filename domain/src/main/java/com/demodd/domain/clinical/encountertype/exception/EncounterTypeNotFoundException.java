package com.demodd.domain.clinical.encountertype.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.encountertype.model.valueobject.EncounterTypeId;

public class EncounterTypeNotFoundException extends DomainException {

    public EncounterTypeNotFoundException(EncounterTypeId id) {
        super("No se encontro la entidad EncounterType con identificador: " + id.value());
    }

    public EncounterTypeNotFoundException(String message) {
        super(message);
    }
}
