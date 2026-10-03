package com.demodd.application.chat.chatmessage.port.in;

import com.demodd.application.chat.chatmessage.dto.ChatMessageResponse;

public interface CreateChatMessageUseCase {

    ChatMessageResponse execute(String name);
}
