package com.demodd.domain.chat.chatconversationaisetting.port.repository;

import com.demodd.domain.chat.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;
import com.demodd.domain.chat.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

import java.util.List;
import java.util.Optional;

public interface ChatConversationAiSettingRepositoryPort {

    ChatConversationAiSetting save(ChatConversationAiSetting entity);

    Optional<ChatConversationAiSetting> findById(ChatConversationAiSettingId id);

    List<ChatConversationAiSetting> findAll();

    void deleteById(ChatConversationAiSettingId id);

    boolean existsById(ChatConversationAiSettingId id);
}
