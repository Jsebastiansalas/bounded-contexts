package com.demodd.application.geography.documenttype.port.in;

import com.demodd.application.geography.documenttype.dto.DocumentTypeResponse;

import java.util.UUID;

public interface UpdateDocumentTypeUseCase {

    DocumentTypeResponse execute(UUID id, String name, String status);
}
