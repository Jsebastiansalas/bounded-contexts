package com.demodd.domain.chat.chatairunmetric.exception;

import com.demodd.domain.common.DomainException;

public class ChatAiRunMetricAlreadyExistsException extends DomainException {

    public ChatAiRunMetricAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ChatAiRunMetric con identificador: " + identifier);
    }
}
