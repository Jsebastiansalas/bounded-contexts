package com.demodd.domain.chat.chatescalation.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.chatescalation.model.valueobject.ChatEscalationId;

public class ChatEscalationNotFoundException extends DomainException {

    public ChatEscalationNotFoundException(ChatEscalationId id) {
        super("No se encontro la entidad ChatEscalation con identificador: " + id.value());
    }

    public ChatEscalationNotFoundException(String message) {
        super(message);
    }
}
