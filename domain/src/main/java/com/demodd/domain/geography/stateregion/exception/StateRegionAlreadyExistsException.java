package com.demodd.domain.geography.stateregion.exception;

import com.demodd.domain.common.DomainException;

public class StateRegionAlreadyExistsException extends DomainException {

    public StateRegionAlreadyExistsException(String identifier) {
        super("Ya existe un registro de StateRegion con identificador: " + identifier);
    }
}
