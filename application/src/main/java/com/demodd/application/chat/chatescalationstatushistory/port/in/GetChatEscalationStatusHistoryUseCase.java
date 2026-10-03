package com.demodd.application.chat.chatescalationstatushistory.port.in;

import com.demodd.application.chat.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;

import java.util.List;
import java.util.UUID;

public interface GetChatEscalationStatusHistoryUseCase {

    ChatEscalationStatusHistoryResponse getById(UUID id);

    List<ChatEscalationStatusHistoryResponse> getAll();
}
