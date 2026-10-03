package com.demodd.application.chat.conversationstatus.port.in;

import com.demodd.application.chat.conversationstatus.dto.ConversationStatusResponse;

import java.util.List;
import java.util.UUID;

public interface GetConversationStatusUseCase {

    ConversationStatusResponse getById(UUID id);

    List<ConversationStatusResponse> getAll();
}
