package com.demodd.infrastructure.chat.chatconversationaisetting.adapter.out.persistence;

import com.demodd.domain.chat.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;
import com.demodd.domain.chat.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.demodd.domain.chat.chatconversationaisetting.model.valueobject.ChatConversationAiSettingName;
import com.demodd.domain.chat.chatconversationaisetting.model.valueobject.ChatConversationAiSettingStatus;
import com.demodd.domain.chat.chatconversationaisetting.port.repository.ChatConversationAiSettingRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatConversationAiSettingRepositoryAdapter implements ChatConversationAiSettingRepositoryPort {

    private final ChatConversationAiSettingSpringDataJpaRepository repository;

    public ChatConversationAiSettingRepositoryAdapter(ChatConversationAiSettingSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatConversationAiSetting save(ChatConversationAiSetting entity) {
        ChatConversationAiSettingJpaEntity jpaEntity = new ChatConversationAiSettingJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ChatConversationAiSettingJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ChatConversationAiSetting> findById(ChatConversationAiSettingId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ChatConversationAiSetting> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ChatConversationAiSettingId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ChatConversationAiSettingId id) {
        return repository.existsById(id.value());
    }

    private ChatConversationAiSetting toDomain(ChatConversationAiSettingJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ChatConversationAiSetting(
                ChatConversationAiSettingId.of(jpa.getId()),
                ChatConversationAiSettingName.of(entityName),
                ChatConversationAiSettingStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
