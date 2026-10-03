package com.demodd.application.chat.chatescalationstatushistory.port.in;

import com.demodd.application.chat.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;

import java.util.UUID;

public interface UpdateChatEscalationStatusHistoryUseCase {

    ChatEscalationStatusHistoryResponse execute(UUID id, String name, String status);
}
