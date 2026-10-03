package com.demodd.application.chat.messagetype.port.in;

import java.util.UUID;

public interface DeleteMessageTypeUseCase {

    void execute(UUID id);
}
