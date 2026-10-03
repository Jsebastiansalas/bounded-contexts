package com.demodd.application.chat.chatescalationassignment.port.in;

import com.demodd.application.chat.chatescalationassignment.dto.ChatEscalationAssignmentResponse;

import java.util.UUID;

public interface UpdateChatEscalationAssignmentUseCase {

    ChatEscalationAssignmentResponse execute(UUID id, String name, String status);
}
