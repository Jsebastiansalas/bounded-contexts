package com.demodd.application.chat.providermodelai.port.in;

import com.demodd.application.chat.providermodelai.dto.ProviderModelAiResponse;

import java.util.List;
import java.util.UUID;

public interface GetProviderModelAiUseCase {

    ProviderModelAiResponse getById(UUID id);

    List<ProviderModelAiResponse> getAll();
}
