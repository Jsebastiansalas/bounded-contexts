package com.demodd.application.chat.chatairunmetric.port.in;

import com.demodd.application.chat.chatairunmetric.dto.ChatAiRunMetricResponse;

public interface CreateChatAiRunMetricUseCase {

    ChatAiRunMetricResponse execute(String name);
}
