package com.demodd.application.chat.chatairunmetric.port.in;

import com.demodd.application.chat.chatairunmetric.dto.ChatAiRunMetricResponse;

import java.util.List;
import java.util.UUID;

public interface GetChatAiRunMetricUseCase {

    ChatAiRunMetricResponse getById(UUID id);

    List<ChatAiRunMetricResponse> getAll();
}
