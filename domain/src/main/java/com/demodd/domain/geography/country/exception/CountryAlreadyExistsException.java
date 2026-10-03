package com.demodd.domain.geography.country.exception;

import com.demodd.domain.common.DomainException;

public class CountryAlreadyExistsException extends DomainException {

    public CountryAlreadyExistsException(String identifier) {
        super("Ya existe un registro de Country con identificador: " + identifier);
    }
}
