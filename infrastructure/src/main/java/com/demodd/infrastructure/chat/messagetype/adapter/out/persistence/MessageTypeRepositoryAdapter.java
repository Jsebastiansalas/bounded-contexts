package com.demodd.infrastructure.chat.messagetype.adapter.out.persistence;

import com.demodd.domain.chat.messagetype.model.aggregate.MessageType;
import com.demodd.domain.chat.messagetype.model.valueobject.MessageTypeId;
import com.demodd.domain.chat.messagetype.model.valueobject.MessageTypeName;
import com.demodd.domain.chat.messagetype.model.valueobject.MessageTypeStatus;
import com.demodd.domain.chat.messagetype.port.repository.MessageTypeRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MessageTypeRepositoryAdapter implements MessageTypeRepositoryPort {

    private final MessageTypeSpringDataJpaRepository repository;

    public MessageTypeRepositoryAdapter(MessageTypeSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public MessageType save(MessageType entity) {
        MessageTypeJpaEntity jpaEntity = new MessageTypeJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        MessageTypeJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<MessageType> findById(MessageTypeId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<MessageType> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(MessageTypeId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(MessageTypeId id) {
        return repository.existsById(id.value());
    }

    private MessageType toDomain(MessageTypeJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new MessageType(
                MessageTypeId.of(jpa.getId()),
                MessageTypeName.of(entityName),
                MessageTypeStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
