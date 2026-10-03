package com.demodd.domain.chat.messagetype.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.messagetype.model.valueobject.MessageTypeId;

public class MessageTypeNotFoundException extends DomainException {

    public MessageTypeNotFoundException(MessageTypeId id) {
        super("No se encontro la entidad MessageType con identificador: " + id.value());
    }

    public MessageTypeNotFoundException(String message) {
        super(message);
    }
}
