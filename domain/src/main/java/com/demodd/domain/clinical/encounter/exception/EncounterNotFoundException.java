package com.demodd.domain.clinical.encounter.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.encounter.model.valueobject.EncounterId;

public class EncounterNotFoundException extends DomainException {

    public EncounterNotFoundException(EncounterId id) {
        super("No se encontro la entidad Encounter con identificador: " + id.value());
    }

    public EncounterNotFoundException(String message) {
        super(message);
    }
}
