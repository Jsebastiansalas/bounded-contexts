package com.demodd.application.chat.chatconversation.port.in;

import com.demodd.application.chat.chatconversation.dto.ChatConversationResponse;

import java.util.List;
import java.util.UUID;

public interface GetChatConversationUseCase {

    ChatConversationResponse getById(UUID id);

    List<ChatConversationResponse> getAll();
}
