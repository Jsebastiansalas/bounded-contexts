package com.demodd.domain.chat.chatescalation.port.repository;

import com.demodd.domain.chat.chatescalation.model.aggregate.ChatEscalation;
import com.demodd.domain.chat.chatescalation.model.valueobject.ChatEscalationId;

import java.util.List;
import java.util.Optional;

public interface ChatEscalationRepositoryPort {

    ChatEscalation save(ChatEscalation entity);

    Optional<ChatEscalation> findById(ChatEscalationId id);

    List<ChatEscalation> findAll();

    void deleteById(ChatEscalationId id);

    boolean existsById(ChatEscalationId id);
}
