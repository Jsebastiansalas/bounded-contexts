package com.demodd.application.chat.chatairunerror.port.in;

import com.demodd.application.chat.chatairunerror.dto.ChatAiRunErrorResponse;

import java.util.List;
import java.util.UUID;

public interface GetChatAiRunErrorUseCase {

    ChatAiRunErrorResponse getById(UUID id);

    List<ChatAiRunErrorResponse> getAll();
}
