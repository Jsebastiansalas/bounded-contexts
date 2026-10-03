package com.demodd.application.chat.providermodelai.port.in;

import com.demodd.application.chat.providermodelai.dto.ProviderModelAiResponse;

import java.util.UUID;

public interface UpdateProviderModelAiUseCase {

    ProviderModelAiResponse execute(UUID id, String name, String status);
}
