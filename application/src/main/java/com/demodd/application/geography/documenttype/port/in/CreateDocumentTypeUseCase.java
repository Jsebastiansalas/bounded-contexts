package com.demodd.application.geography.documenttype.port.in;

import com.demodd.application.geography.documenttype.dto.DocumentTypeResponse;

public interface CreateDocumentTypeUseCase {

    DocumentTypeResponse execute(String name);
}
