package com.demodd.infrastructure.chat.chatairunmetric.adapter.out.persistence;

import com.demodd.domain.chat.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.demodd.domain.chat.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.demodd.domain.chat.chatairunmetric.model.valueobject.ChatAiRunMetricName;
import com.demodd.domain.chat.chatairunmetric.model.valueobject.ChatAiRunMetricStatus;
import com.demodd.domain.chat.chatairunmetric.port.repository.ChatAiRunMetricRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatAiRunMetricRepositoryAdapter implements ChatAiRunMetricRepositoryPort {

    private final ChatAiRunMetricSpringDataJpaRepository repository;

    public ChatAiRunMetricRepositoryAdapter(ChatAiRunMetricSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatAiRunMetric save(ChatAiRunMetric entity) {
        ChatAiRunMetricJpaEntity jpaEntity = new ChatAiRunMetricJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ChatAiRunMetricJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ChatAiRunMetric> findById(ChatAiRunMetricId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ChatAiRunMetric> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ChatAiRunMetricId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ChatAiRunMetricId id) {
        return repository.existsById(id.value());
    }

    private ChatAiRunMetric toDomain(ChatAiRunMetricJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ChatAiRunMetric(
                ChatAiRunMetricId.of(jpa.getId()),
                ChatAiRunMetricName.of(entityName),
                ChatAiRunMetricStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
