package com.demodd.application.chat.sendertype.port.in;

import com.demodd.application.chat.sendertype.dto.SenderTypeResponse;

import java.util.UUID;

public interface UpdateSenderTypeUseCase {

    SenderTypeResponse execute(UUID id, String name, String status);
}
