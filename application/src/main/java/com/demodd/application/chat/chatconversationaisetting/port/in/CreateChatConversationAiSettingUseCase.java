package com.demodd.application.chat.chatconversationaisetting.port.in;

import com.demodd.application.chat.chatconversationaisetting.dto.ChatConversationAiSettingResponse;

public interface CreateChatConversationAiSettingUseCase {

    ChatConversationAiSettingResponse execute(String name);
}
