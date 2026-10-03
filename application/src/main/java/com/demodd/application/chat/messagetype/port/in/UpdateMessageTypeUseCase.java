package com.demodd.application.chat.messagetype.port.in;

import com.demodd.application.chat.messagetype.dto.MessageTypeResponse;

import java.util.UUID;

public interface UpdateMessageTypeUseCase {

    MessageTypeResponse execute(UUID id, String name, String status);
}
