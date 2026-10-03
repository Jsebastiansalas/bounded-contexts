package com.demodd.domain.chat.chatairun.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.chatairun.model.valueobject.ChatAiRunId;

public class ChatAiRunNotFoundException extends DomainException {

    public ChatAiRunNotFoundException(ChatAiRunId id) {
        super("No se encontro la entidad ChatAiRun con identificador: " + id.value());
    }

    public ChatAiRunNotFoundException(String message) {
        super(message);
    }
}
