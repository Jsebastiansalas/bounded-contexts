package com.demodd.domain.clinical.encounterstatus.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.encounterstatus.model.valueobject.EncounterStatusId;

public class EncounterStatusNotFoundException extends DomainException {

    public EncounterStatusNotFoundException(EncounterStatusId id) {
        super("No se encontro la entidad EncounterStatus con identificador: " + id.value());
    }

    public EncounterStatusNotFoundException(String message) {
        super(message);
    }
}
