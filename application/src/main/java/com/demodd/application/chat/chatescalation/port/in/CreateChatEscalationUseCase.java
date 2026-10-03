package com.demodd.application.chat.chatescalation.port.in;

import com.demodd.application.chat.chatescalation.dto.ChatEscalationResponse;

public interface CreateChatEscalationUseCase {

    ChatEscalationResponse execute(String name);
}
