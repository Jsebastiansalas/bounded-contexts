package com.demodd.application.chat.chatairun.port.in;

import com.demodd.application.chat.chatairun.dto.ChatAiRunResponse;

public interface CreateChatAiRunUseCase {

    ChatAiRunResponse execute(String name);
}
