package com.demodd.domain.chat.conversationstatus.port.repository;

import com.demodd.domain.chat.conversationstatus.model.aggregate.ConversationStatus;
import com.demodd.domain.chat.conversationstatus.model.valueobject.ConversationStatusId;

import java.util.List;
import java.util.Optional;

public interface ConversationStatusRepositoryPort {

    ConversationStatus save(ConversationStatus entity);

    Optional<ConversationStatus> findById(ConversationStatusId id);

    List<ConversationStatus> findAll();

    void deleteById(ConversationStatusId id);

    boolean existsById(ConversationStatusId id);
}
