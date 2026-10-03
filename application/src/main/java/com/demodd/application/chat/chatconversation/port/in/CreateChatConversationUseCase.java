package com.demodd.application.chat.chatconversation.port.in;

import com.demodd.application.chat.chatconversation.dto.ChatConversationResponse;

public interface CreateChatConversationUseCase {

    ChatConversationResponse execute(String name);
}
