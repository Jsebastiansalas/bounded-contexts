package com.demodd.application.chat.chatparticipant.port.in;

import java.util.UUID;

public interface DeleteChatParticipantUseCase {

    void execute(UUID id);
}
