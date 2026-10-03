package com.demodd.application.chat.aimodel.port.in;

import java.util.UUID;

public interface DeleteAiModelUseCase {

    void execute(UUID id);
}
