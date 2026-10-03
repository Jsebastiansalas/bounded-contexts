package com.demodd.application.chat.escalationstatus.port.in;

import com.demodd.application.chat.escalationstatus.dto.EscalationStatusResponse;

import java.util.List;
import java.util.UUID;

public interface GetEscalationStatusUseCase {

    EscalationStatusResponse getById(UUID id);

    List<EscalationStatusResponse> getAll();
}
