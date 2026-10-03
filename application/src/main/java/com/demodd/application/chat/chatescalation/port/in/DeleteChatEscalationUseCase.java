package com.demodd.application.chat.chatescalation.port.in;

import java.util.UUID;

public interface DeleteChatEscalationUseCase {

    void execute(UUID id);
}
