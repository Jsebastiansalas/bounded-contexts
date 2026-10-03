package com.demodd.application.chat.chatparticipant.port.in;

import com.demodd.application.chat.chatparticipant.dto.ChatParticipantResponse;

import java.util.UUID;

public interface UpdateChatParticipantUseCase {

    ChatParticipantResponse execute(UUID id, String name, String status);
}
