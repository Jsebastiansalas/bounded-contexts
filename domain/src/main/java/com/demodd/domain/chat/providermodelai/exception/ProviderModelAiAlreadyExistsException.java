package com.demodd.domain.chat.providermodelai.exception;

import com.demodd.domain.common.DomainException;

public class ProviderModelAiAlreadyExistsException extends DomainException {

    public ProviderModelAiAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ProviderModelAi con identificador: " + identifier);
    }
}
