package com.demodd.application.chat.priority.port.in;

import com.demodd.application.chat.priority.dto.PriorityResponse;

public interface CreatePriorityUseCase {

    PriorityResponse execute(String name);
}
