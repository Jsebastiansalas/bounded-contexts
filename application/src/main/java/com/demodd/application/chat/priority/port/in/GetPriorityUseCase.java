package com.demodd.application.chat.priority.port.in;

import com.demodd.application.chat.priority.dto.PriorityResponse;

import java.util.List;
import java.util.UUID;

public interface GetPriorityUseCase {

    PriorityResponse getById(UUID id);

    List<PriorityResponse> getAll();
}
