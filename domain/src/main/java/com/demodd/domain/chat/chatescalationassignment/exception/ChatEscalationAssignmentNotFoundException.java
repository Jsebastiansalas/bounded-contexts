package com.demodd.domain.chat.chatescalationassignment.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

public class ChatEscalationAssignmentNotFoundException extends DomainException {

    public ChatEscalationAssignmentNotFoundException(ChatEscalationAssignmentId id) {
        super("No se encontro la entidad ChatEscalationAssignment con identificador: " + id.value());
    }

    public ChatEscalationAssignmentNotFoundException(String message) {
        super(message);
    }
}
