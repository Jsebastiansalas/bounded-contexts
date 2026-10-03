package com.demodd.application.chat.escalationstatus.port.in;

import java.util.UUID;

public interface DeleteEscalationStatusUseCase {

    void execute(UUID id);
}
