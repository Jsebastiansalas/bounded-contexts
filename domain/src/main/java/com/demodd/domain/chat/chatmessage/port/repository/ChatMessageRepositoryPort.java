package com.demodd.domain.chat.chatmessage.port.repository;

import com.demodd.domain.chat.chatmessage.model.aggregate.ChatMessage;
import com.demodd.domain.chat.chatmessage.model.valueobject.ChatMessageId;

import java.util.List;
import java.util.Optional;

public interface ChatMessageRepositoryPort {

    ChatMessage save(ChatMessage entity);

    Optional<ChatMessage> findById(ChatMessageId id);

    List<ChatMessage> findAll();

    void deleteById(ChatMessageId id);

    boolean existsById(ChatMessageId id);
}
