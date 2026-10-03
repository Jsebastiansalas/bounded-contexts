package com.demodd.application.chat.messagetype.port.in;

import com.demodd.application.chat.messagetype.dto.MessageTypeResponse;

import java.util.List;
import java.util.UUID;

public interface GetMessageTypeUseCase {

    MessageTypeResponse getById(UUID id);

    List<MessageTypeResponse> getAll();
}
