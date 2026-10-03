package com.demodd.domain.chat.chatparticipant.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.chatparticipant.model.valueobject.ChatParticipantId;

public class ChatParticipantNotFoundException extends DomainException {

    public ChatParticipantNotFoundException(ChatParticipantId id) {
        super("No se encontro la entidad ChatParticipant con identificador: " + id.value());
    }

    public ChatParticipantNotFoundException(String message) {
        super(message);
    }
}
