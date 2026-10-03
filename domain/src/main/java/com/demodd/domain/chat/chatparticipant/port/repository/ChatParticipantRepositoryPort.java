package com.demodd.domain.chat.chatparticipant.port.repository;

import com.demodd.domain.chat.chatparticipant.model.aggregate.ChatParticipant;
import com.demodd.domain.chat.chatparticipant.model.valueobject.ChatParticipantId;

import java.util.List;
import java.util.Optional;

public interface ChatParticipantRepositoryPort {

    ChatParticipant save(ChatParticipant entity);

    Optional<ChatParticipant> findById(ChatParticipantId id);

    List<ChatParticipant> findAll();

    void deleteById(ChatParticipantId id);

    boolean existsById(ChatParticipantId id);
}
