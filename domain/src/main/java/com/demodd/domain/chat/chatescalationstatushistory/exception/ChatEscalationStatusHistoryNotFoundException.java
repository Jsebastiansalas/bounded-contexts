package com.demodd.domain.chat.chatescalationstatushistory.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

public class ChatEscalationStatusHistoryNotFoundException extends DomainException {

    public ChatEscalationStatusHistoryNotFoundException(ChatEscalationStatusHistoryId id) {
        super("No se encontro la entidad ChatEscalationStatusHistory con identificador: " + id.value());
    }

    public ChatEscalationStatusHistoryNotFoundException(String message) {
        super(message);
    }
}
