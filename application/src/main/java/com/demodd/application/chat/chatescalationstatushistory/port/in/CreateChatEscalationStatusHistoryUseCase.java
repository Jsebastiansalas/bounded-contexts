package com.demodd.application.chat.chatescalationstatushistory.port.in;

import com.demodd.application.chat.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;

public interface CreateChatEscalationStatusHistoryUseCase {

    ChatEscalationStatusHistoryResponse execute(String name);
}
