package com.demodd.application.chat.chatconversationaisetting.port.in;

import com.demodd.application.chat.chatconversationaisetting.dto.ChatConversationAiSettingResponse;

import java.util.UUID;

public interface UpdateChatConversationAiSettingUseCase {

    ChatConversationAiSettingResponse execute(UUID id, String name, String status);
}
