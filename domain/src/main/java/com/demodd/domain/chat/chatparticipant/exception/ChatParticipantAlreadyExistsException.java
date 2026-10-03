package com.demodd.domain.chat.chatparticipant.exception;

import com.demodd.domain.common.DomainException;

public class ChatParticipantAlreadyExistsException extends DomainException {

    public ChatParticipantAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ChatParticipant con identificador: " + identifier);
    }
}
