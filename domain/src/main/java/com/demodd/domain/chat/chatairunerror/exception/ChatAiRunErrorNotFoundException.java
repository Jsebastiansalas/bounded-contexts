package com.demodd.domain.chat.chatairunerror.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.chatairunerror.model.valueobject.ChatAiRunErrorId;

public class ChatAiRunErrorNotFoundException extends DomainException {

    public ChatAiRunErrorNotFoundException(ChatAiRunErrorId id) {
        super("No se encontro la entidad ChatAiRunError con identificador: " + id.value());
    }

    public ChatAiRunErrorNotFoundException(String message) {
        super(message);
    }
}
