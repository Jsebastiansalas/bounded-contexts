package com.demodd.domain.chat.chatescalationassignment.exception;

import com.demodd.domain.common.DomainException;

public class ChatEscalationAssignmentAlreadyExistsException extends DomainException {

    public ChatEscalationAssignmentAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ChatEscalationAssignment con identificador: " + identifier);
    }
}
