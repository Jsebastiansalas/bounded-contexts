package com.demodd.application.chat.messagetype.port.in;

import com.demodd.application.chat.messagetype.dto.MessageTypeResponse;

public interface CreateMessageTypeUseCase {

    MessageTypeResponse execute(String name);
}
