package com.demodd.application.chat.airunstatus.port.in;

import com.demodd.application.chat.airunstatus.dto.AiRunStatusResponse;

import java.util.UUID;

public interface UpdateAiRunStatusUseCase {

    AiRunStatusResponse execute(UUID id, String name, String status);
}
