package com.demodd.application.chat.chatconversationaisetting.port.in;

import com.demodd.application.chat.chatconversationaisetting.dto.ChatConversationAiSettingResponse;

import java.util.List;
import java.util.UUID;

public interface GetChatConversationAiSettingUseCase {

    ChatConversationAiSettingResponse getById(UUID id);

    List<ChatConversationAiSettingResponse> getAll();
}
