package com.demodd.domain.chat.chatconversation.port.repository;

import com.demodd.domain.chat.chatconversation.model.aggregate.ChatConversation;
import com.demodd.domain.chat.chatconversation.model.valueobject.ChatConversationId;

import java.util.List;
import java.util.Optional;

public interface ChatConversationRepositoryPort {

    ChatConversation save(ChatConversation entity);

    Optional<ChatConversation> findById(ChatConversationId id);

    List<ChatConversation> findAll();

    void deleteById(ChatConversationId id);

    boolean existsById(ChatConversationId id);
}
