package com.demodd.application.chat.chatescalation.port.in;

import com.demodd.application.chat.chatescalation.dto.ChatEscalationResponse;

import java.util.UUID;

public interface UpdateChatEscalationUseCase {

    ChatEscalationResponse execute(UUID id, String name, String status);
}
