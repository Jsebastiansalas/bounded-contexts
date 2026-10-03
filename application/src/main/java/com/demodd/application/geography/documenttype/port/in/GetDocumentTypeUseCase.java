package com.demodd.application.geography.documenttype.port.in;

import com.demodd.application.geography.documenttype.dto.DocumentTypeResponse;

import java.util.List;
import java.util.UUID;

public interface GetDocumentTypeUseCase {

    DocumentTypeResponse getById(UUID id);

    List<DocumentTypeResponse> getAll();
}
