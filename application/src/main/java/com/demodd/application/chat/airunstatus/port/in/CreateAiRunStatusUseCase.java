package com.demodd.application.chat.airunstatus.port.in;

import com.demodd.application.chat.airunstatus.dto.AiRunStatusResponse;

public interface CreateAiRunStatusUseCase {

    AiRunStatusResponse execute(String name);
}
