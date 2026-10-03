package com.demodd.domain.geography.gender.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.geography.gender.model.valueobject.GenderId;

public class GenderNotFoundException extends DomainException {

    public GenderNotFoundException(GenderId id) {
        super("No se encontro la entidad Gender con identificador: " + id.value());
    }

    public GenderNotFoundException(String message) {
        super(message);
    }
}
