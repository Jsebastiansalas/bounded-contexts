package com.demodd.domain.geography.documenttype.port.repository;

import com.demodd.domain.geography.documenttype.model.aggregate.DocumentType;
import com.demodd.domain.geography.documenttype.model.valueobject.DocumentTypeId;

import java.util.List;
import java.util.Optional;

public interface DocumentTypeRepositoryPort {

    DocumentType save(DocumentType entity);

    Optional<DocumentType> findById(DocumentTypeId id);

    List<DocumentType> findAll();

    void deleteById(DocumentTypeId id);

    boolean existsById(DocumentTypeId id);
}
