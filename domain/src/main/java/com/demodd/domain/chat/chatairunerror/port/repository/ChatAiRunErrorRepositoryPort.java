package com.demodd.domain.chat.chatairunerror.port.repository;

import com.demodd.domain.chat.chatairunerror.model.aggregate.ChatAiRunError;
import com.demodd.domain.chat.chatairunerror.model.valueobject.ChatAiRunErrorId;

import java.util.List;
import java.util.Optional;

public interface ChatAiRunErrorRepositoryPort {

    ChatAiRunError save(ChatAiRunError entity);

    Optional<ChatAiRunError> findById(ChatAiRunErrorId id);

    List<ChatAiRunError> findAll();

    void deleteById(ChatAiRunErrorId id);

    boolean existsById(ChatAiRunErrorId id);
}
