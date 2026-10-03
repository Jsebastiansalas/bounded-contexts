package com.demodd.domain.geography.country.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.geography.country.model.valueobject.CountryId;

public class CountryNotFoundException extends DomainException {

    public CountryNotFoundException(CountryId id) {
        super("No se encontro la entidad Country con identificador: " + id.value());
    }

    public CountryNotFoundException(String message) {
        super(message);
    }
}
