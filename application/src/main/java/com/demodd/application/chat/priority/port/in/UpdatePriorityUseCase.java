package com.demodd.application.chat.priority.port.in;

import com.demodd.application.chat.priority.dto.PriorityResponse;

import java.util.UUID;

public interface UpdatePriorityUseCase {

    PriorityResponse execute(UUID id, String name, String status);
}
