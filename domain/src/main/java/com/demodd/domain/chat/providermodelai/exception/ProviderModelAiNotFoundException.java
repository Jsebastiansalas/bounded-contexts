package com.demodd.domain.chat.providermodelai.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.chat.providermodelai.model.valueobject.ProviderModelAiId;

public class ProviderModelAiNotFoundException extends DomainException {

    public ProviderModelAiNotFoundException(ProviderModelAiId id) {
        super("No se encontro la entidad ProviderModelAi con identificador: " + id.value());
    }

    public ProviderModelAiNotFoundException(String message) {
        super(message);
    }
}
