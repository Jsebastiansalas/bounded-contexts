package com.demodd.application.chat.chatmessage.port.in;

import java.util.UUID;

public interface DeleteChatMessageUseCase {

    void execute(UUID id);
}
