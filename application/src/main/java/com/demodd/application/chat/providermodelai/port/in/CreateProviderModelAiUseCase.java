package com.demodd.application.chat.providermodelai.port.in;

import com.demodd.application.chat.providermodelai.dto.ProviderModelAiResponse;

public interface CreateProviderModelAiUseCase {

    ProviderModelAiResponse execute(String name);
}
