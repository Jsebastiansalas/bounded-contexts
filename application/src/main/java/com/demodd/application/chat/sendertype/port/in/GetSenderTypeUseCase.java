package com.demodd.application.chat.sendertype.port.in;

import com.demodd.application.chat.sendertype.dto.SenderTypeResponse;

import java.util.List;
import java.util.UUID;

public interface GetSenderTypeUseCase {

    SenderTypeResponse getById(UUID id);

    List<SenderTypeResponse> getAll();
}
