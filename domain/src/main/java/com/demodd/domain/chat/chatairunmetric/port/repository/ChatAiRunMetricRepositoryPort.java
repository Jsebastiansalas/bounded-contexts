package com.demodd.domain.chat.chatairunmetric.port.repository;

import com.demodd.domain.chat.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.demodd.domain.chat.chatairunmetric.model.valueobject.ChatAiRunMetricId;

import java.util.List;
import java.util.Optional;

public interface ChatAiRunMetricRepositoryPort {

    ChatAiRunMetric save(ChatAiRunMetric entity);

    Optional<ChatAiRunMetric> findById(ChatAiRunMetricId id);

    List<ChatAiRunMetric> findAll();

    void deleteById(ChatAiRunMetricId id);

    boolean existsById(ChatAiRunMetricId id);
}
