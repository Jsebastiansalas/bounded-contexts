package com.demodd.application.chat.chatescalationassignment.port.in;

import com.demodd.application.chat.chatescalationassignment.dto.ChatEscalationAssignmentResponse;

import java.util.List;
import java.util.UUID;

public interface GetChatEscalationAssignmentUseCase {

    ChatEscalationAssignmentResponse getById(UUID id);

    List<ChatEscalationAssignmentResponse> getAll();
}
