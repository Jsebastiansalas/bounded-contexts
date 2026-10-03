package com.demodd.application.chat.escalationstatus.port.in;

import com.demodd.application.chat.escalationstatus.dto.EscalationStatusResponse;

public interface CreateEscalationStatusUseCase {

    EscalationStatusResponse execute(String name);
}
