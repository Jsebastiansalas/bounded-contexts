package com.demodd.application.chat.chatairun.port.in;

import com.demodd.application.chat.chatairun.dto.ChatAiRunResponse;

import java.util.List;
import java.util.UUID;

public interface GetChatAiRunUseCase {

    ChatAiRunResponse getById(UUID id);

    List<ChatAiRunResponse> getAll();
}
