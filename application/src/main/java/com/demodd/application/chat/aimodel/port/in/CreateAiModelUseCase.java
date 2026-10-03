package com.demodd.application.chat.aimodel.port.in;

import com.demodd.application.chat.aimodel.dto.AiModelResponse;

public interface CreateAiModelUseCase {

    AiModelResponse execute(String name);
}
