package com.demodd.domain.chat.chatairunerror.exception;

import com.demodd.domain.common.DomainException;

public class ChatAiRunErrorAlreadyExistsException extends DomainException {

    public ChatAiRunErrorAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ChatAiRunError con identificador: " + identifier);
    }
}
