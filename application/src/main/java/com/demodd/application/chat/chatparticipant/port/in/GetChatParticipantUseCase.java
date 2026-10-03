package com.demodd.application.chat.chatparticipant.port.in;

import com.demodd.application.chat.chatparticipant.dto.ChatParticipantResponse;

import java.util.List;
import java.util.UUID;

public interface GetChatParticipantUseCase {

    ChatParticipantResponse getById(UUID id);

    List<ChatParticipantResponse> getAll();
}
