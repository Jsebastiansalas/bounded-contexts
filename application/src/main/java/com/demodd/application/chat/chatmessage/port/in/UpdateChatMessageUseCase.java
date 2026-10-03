package com.demodd.application.chat.chatmessage.port.in;

import com.demodd.application.chat.chatmessage.dto.ChatMessageResponse;

import java.util.UUID;

public interface UpdateChatMessageUseCase {

    ChatMessageResponse execute(UUID id, String name, String status);
}
