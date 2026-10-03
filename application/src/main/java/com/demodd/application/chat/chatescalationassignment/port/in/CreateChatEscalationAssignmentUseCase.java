package com.demodd.application.chat.chatescalationassignment.port.in;

import com.demodd.application.chat.chatescalationassignment.dto.ChatEscalationAssignmentResponse;

public interface CreateChatEscalationAssignmentUseCase {

    ChatEscalationAssignmentResponse execute(String name);
}
