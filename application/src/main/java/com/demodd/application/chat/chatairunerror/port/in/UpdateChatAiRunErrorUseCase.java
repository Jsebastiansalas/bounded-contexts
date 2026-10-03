package com.demodd.application.chat.chatairunerror.port.in;

import com.demodd.application.chat.chatairunerror.dto.ChatAiRunErrorResponse;

import java.util.UUID;

public interface UpdateChatAiRunErrorUseCase {

    ChatAiRunErrorResponse execute(UUID id, String name, String status);
}
