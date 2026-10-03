package com.demodd.application.chat.chatparticipant.port.in;

import com.demodd.application.chat.chatparticipant.dto.ChatParticipantResponse;

public interface CreateChatParticipantUseCase {

    ChatParticipantResponse execute(String name);
}
