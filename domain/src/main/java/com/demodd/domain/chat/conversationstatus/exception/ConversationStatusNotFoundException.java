package com.demodd.domain.chat.conversationstatus.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.conversationstatus.model.valueobject.ConversationStatusId;

public class ConversationStatusNotFoundException extends DomainException {

    public ConversationStatusNotFoundException(ConversationStatusId id) {
        super("No se encontro la entidad ConversationStatus con identificador: " + id.value());
    }

    public ConversationStatusNotFoundException(String message) {
        super(message);
    }
}
