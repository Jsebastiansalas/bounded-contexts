package com.demodd.application.chat.chatairunerror.port.in;

import com.demodd.application.chat.chatairunerror.dto.ChatAiRunErrorResponse;

public interface CreateChatAiRunErrorUseCase {

    ChatAiRunErrorResponse execute(String name);
}
