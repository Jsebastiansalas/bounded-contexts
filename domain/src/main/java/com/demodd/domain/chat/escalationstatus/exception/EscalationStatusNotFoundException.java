package com.demodd.domain.chat.escalationstatus.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.escalationstatus.model.valueobject.EscalationStatusId;

public class EscalationStatusNotFoundException extends DomainException {

    public EscalationStatusNotFoundException(EscalationStatusId id) {
        super("No se encontro la entidad EscalationStatus con identificador: " + id.value());
    }

    public EscalationStatusNotFoundException(String message) {
        super(message);
    }
}
