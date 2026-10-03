package com.demodd.application.chat.chatairun.port.in;

import com.demodd.application.chat.chatairun.dto.ChatAiRunResponse;

import java.util.UUID;

public interface UpdateChatAiRunUseCase {

    ChatAiRunResponse execute(UUID id, String name, String status);
}
