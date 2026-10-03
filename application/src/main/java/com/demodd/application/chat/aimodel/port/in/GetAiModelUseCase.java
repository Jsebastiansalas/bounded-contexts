package com.demodd.application.chat.aimodel.port.in;

import com.demodd.application.chat.aimodel.dto.AiModelResponse;

import java.util.List;
import java.util.UUID;

public interface GetAiModelUseCase {

    AiModelResponse getById(UUID id);

    List<AiModelResponse> getAll();
}
