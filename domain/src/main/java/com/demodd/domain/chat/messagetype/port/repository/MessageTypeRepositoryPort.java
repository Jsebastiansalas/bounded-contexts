package com.demodd.domain.chat.messagetype.port.repository;

import com.demodd.domain.chat.messagetype.model.aggregate.MessageType;
import com.demodd.domain.chat.messagetype.model.valueobject.MessageTypeId;

import java.util.List;
import java.util.Optional;

public interface MessageTypeRepositoryPort {

    MessageType save(MessageType entity);

    Optional<MessageType> findById(MessageTypeId id);

    List<MessageType> findAll();

    void deleteById(MessageTypeId id);

    boolean existsById(MessageTypeId id);
}
