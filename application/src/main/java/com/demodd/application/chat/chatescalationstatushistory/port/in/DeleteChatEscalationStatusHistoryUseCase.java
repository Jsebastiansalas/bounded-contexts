package com.demodd.application.chat.chatescalationstatushistory.port.in;

import java.util.UUID;

public interface DeleteChatEscalationStatusHistoryUseCase {

    void execute(UUID id);
}
