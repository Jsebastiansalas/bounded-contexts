package com.demodd.application.chat.chatescalation.port.in;

import com.demodd.application.chat.chatescalation.dto.ChatEscalationResponse;

import java.util.List;
import java.util.UUID;

public interface GetChatEscalationUseCase {

    ChatEscalationResponse getById(UUID id);

    List<ChatEscalationResponse> getAll();
}
