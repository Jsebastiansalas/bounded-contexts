package com.demodd.application.chat.aimodel.port.in;

import com.demodd.application.chat.aimodel.dto.AiModelResponse;

import java.util.UUID;

public interface UpdateAiModelUseCase {

    AiModelResponse execute(UUID id, String name, String status);
}
