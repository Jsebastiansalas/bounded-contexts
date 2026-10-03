package com.demodd.domain.geography.stateregion.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.geography.stateregion.model.valueobject.StateRegionId;

public class StateRegionNotFoundException extends DomainException {

    public StateRegionNotFoundException(StateRegionId id) {
        super("No se encontro la entidad StateRegion con identificador: " + id.value());
    }

    public StateRegionNotFoundException(String message) {
        super(message);
    }
}
