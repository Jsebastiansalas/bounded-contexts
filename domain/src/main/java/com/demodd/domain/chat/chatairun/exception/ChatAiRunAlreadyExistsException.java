package com.demodd.domain.chat.chatairun.exception;

import com.demodd.domain.common.DomainException;

public class ChatAiRunAlreadyExistsException extends DomainException {

    public ChatAiRunAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ChatAiRun con identificador: " + identifier);
    }
}
