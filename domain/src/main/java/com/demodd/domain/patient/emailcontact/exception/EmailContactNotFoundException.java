package com.demodd.domain.patient.emailcontact.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.patient.emailcontact.model.valueobject.EmailContactId;

public class EmailContactNotFoundException extends DomainException {

    public EmailContactNotFoundException(EmailContactId id) {
        super("No se encontro la entidad EmailContact con identificador: " + id.value());
    }

    public EmailContactNotFoundException(String message) {
        super(message);
    }
}
