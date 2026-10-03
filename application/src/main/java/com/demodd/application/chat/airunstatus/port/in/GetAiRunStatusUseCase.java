package com.demodd.application.chat.airunstatus.port.in;

import com.demodd.application.chat.airunstatus.dto.AiRunStatusResponse;

import java.util.List;
import java.util.UUID;

public interface GetAiRunStatusUseCase {

    AiRunStatusResponse getById(UUID id);

    List<AiRunStatusResponse> getAll();
}
