package com.demodd.domain.geography.gender.exception;

import com.demodd.domain.common.DomainException;

public class GenderAlreadyExistsException extends DomainException {

    public GenderAlreadyExistsException(String identifier) {
        super("Ya existe un registro de Gender con identificador: " + identifier);
    }
}
