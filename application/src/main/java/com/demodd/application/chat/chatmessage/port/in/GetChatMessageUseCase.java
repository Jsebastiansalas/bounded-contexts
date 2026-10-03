package com.demodd.application.chat.chatmessage.port.in;

import com.demodd.application.chat.chatmessage.dto.ChatMessageResponse;

import java.util.List;
import java.util.UUID;

public interface GetChatMessageUseCase {

    ChatMessageResponse getById(UUID id);

    List<ChatMessageResponse> getAll();
}
