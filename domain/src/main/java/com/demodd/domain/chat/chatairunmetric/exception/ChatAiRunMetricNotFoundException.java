package com.demodd.domain.chat.chatairunmetric.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.chatairunmetric.model.valueobject.ChatAiRunMetricId;

public class ChatAiRunMetricNotFoundException extends DomainException {

    public ChatAiRunMetricNotFoundException(ChatAiRunMetricId id) {
        super("No se encontro la entidad ChatAiRunMetric con identificador: " + id.value());
    }

    public ChatAiRunMetricNotFoundException(String message) {
        super(message);
    }
}
