package com.demodd.application.chat.conversationstatus.port.in;

import com.demodd.application.chat.conversationstatus.dto.ConversationStatusResponse;

import java.util.UUID;

public interface UpdateConversationStatusUseCase {

    ConversationStatusResponse execute(UUID id, String name, String status);
}
