package com.demodd.domain.clinical.consenttype.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.consenttype.model.valueobject.ConsentTypeId;

public class ConsentTypeNotFoundException extends DomainException {

    public ConsentTypeNotFoundException(ConsentTypeId id) {
        super("No se encontro la entidad ConsentType con identificador: " + id.value());
    }

    public ConsentTypeNotFoundException(String message) {
        super(message);
    }
}
