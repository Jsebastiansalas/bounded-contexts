package com.demodd.domain.chat.chatairun.port.repository;

import com.demodd.domain.chat.chatairun.model.aggregate.ChatAiRun;
import com.demodd.domain.chat.chatairun.model.valueobject.ChatAiRunId;

import java.util.List;
import java.util.Optional;

public interface ChatAiRunRepositoryPort {

    ChatAiRun save(ChatAiRun entity);

    Optional<ChatAiRun> findById(ChatAiRunId id);

    List<ChatAiRun> findAll();

    void deleteById(ChatAiRunId id);

    boolean existsById(ChatAiRunId id);
}
