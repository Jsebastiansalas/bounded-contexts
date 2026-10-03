package com.demodd.domain.patient.contact.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.patient.contact.model.valueobject.ContactId;

public class ContactNotFoundException extends DomainException {

    public ContactNotFoundException(ContactId id) {
        super("No se encontro la entidad Contact con identificador: " + id.value());
    }

    public ContactNotFoundException(String message) {
        super(message);
    }
}
