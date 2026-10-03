package com.demodd.domain.patient.phonecontact.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.patient.phonecontact.model.valueobject.PhoneContactId;

public class PhoneContactNotFoundException extends DomainException {

    public PhoneContactNotFoundException(PhoneContactId id) {
        super("No se encontro la entidad PhoneContact con identificador: " + id.value());
    }

    public PhoneContactNotFoundException(String message) {
        super(message);
    }
}
