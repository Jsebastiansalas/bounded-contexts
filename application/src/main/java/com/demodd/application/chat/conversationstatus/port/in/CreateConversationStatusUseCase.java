package com.demodd.application.chat.conversationstatus.port.in;

import com.demodd.application.chat.conversationstatus.dto.ConversationStatusResponse;

public interface CreateConversationStatusUseCase {

    ConversationStatusResponse execute(String name);
}
