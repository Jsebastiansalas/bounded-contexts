package com.demodd.application.chat.chatairunmetric.port.in;

import com.demodd.application.chat.chatairunmetric.dto.ChatAiRunMetricResponse;

import java.util.UUID;

public interface UpdateChatAiRunMetricUseCase {

    ChatAiRunMetricResponse execute(UUID id, String name, String status);
}
