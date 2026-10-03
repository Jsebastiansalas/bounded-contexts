package com.demodd.application.chat.conversationstatus.port.in;

import java.util.UUID;

public interface DeleteConversationStatusUseCase {

    void execute(UUID id);
}
