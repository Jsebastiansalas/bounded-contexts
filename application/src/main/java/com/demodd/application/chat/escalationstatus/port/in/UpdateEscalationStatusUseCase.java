package com.demodd.application.chat.escalationstatus.port.in;

import com.demodd.application.chat.escalationstatus.dto.EscalationStatusResponse;

import java.util.UUID;

public interface UpdateEscalationStatusUseCase {

    EscalationStatusResponse execute(UUID id, String name, String status);
}
