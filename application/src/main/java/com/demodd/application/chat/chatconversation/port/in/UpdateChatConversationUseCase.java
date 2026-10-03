package com.demodd.application.chat.chatconversation.port.in;

import com.demodd.application.chat.chatconversation.dto.ChatConversationResponse;

import java.util.UUID;

public interface UpdateChatConversationUseCase {

    ChatConversationResponse execute(UUID id, String name, String status);
}
