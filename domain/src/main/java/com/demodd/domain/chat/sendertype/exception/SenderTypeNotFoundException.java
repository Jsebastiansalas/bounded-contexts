package com.demodd.domain.chat.sendertype.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.sendertype.model.valueobject.SenderTypeId;

public class SenderTypeNotFoundException extends DomainException {

    public SenderTypeNotFoundException(SenderTypeId id) {
        super("No se encontro la entidad SenderType con identificador: " + id.value());
    }

    public SenderTypeNotFoundException(String message) {
        super(message);
    }
}
