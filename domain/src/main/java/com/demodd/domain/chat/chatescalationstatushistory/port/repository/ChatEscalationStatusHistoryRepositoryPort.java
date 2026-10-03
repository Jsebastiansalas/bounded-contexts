package com.demodd.domain.chat.chatescalationstatushistory.port.repository;

import com.demodd.domain.chat.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.demodd.domain.chat.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

import java.util.List;
import java.util.Optional;

public interface ChatEscalationStatusHistoryRepositoryPort {

    ChatEscalationStatusHistory save(ChatEscalationStatusHistory entity);

    Optional<ChatEscalationStatusHistory> findById(ChatEscalationStatusHistoryId id);

    List<ChatEscalationStatusHistory> findAll();

    void deleteById(ChatEscalationStatusHistoryId id);

    boolean existsById(ChatEscalationStatusHistoryId id);
}
