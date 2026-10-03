package com.demodd.domain.chat.chatescalationstatushistory.exception;

import com.demodd.domain.common.DomainException;

public class ChatEscalationStatusHistoryAlreadyExistsException extends DomainException {

    public ChatEscalationStatusHistoryAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ChatEscalationStatusHistory con identificador: " + identifier);
    }
}
