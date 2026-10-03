package com.demodd.application.chat.chatconversation.port.in;

import java.util.UUID;

public interface DeleteChatConversationUseCase {

    void execute(UUID id);
}
