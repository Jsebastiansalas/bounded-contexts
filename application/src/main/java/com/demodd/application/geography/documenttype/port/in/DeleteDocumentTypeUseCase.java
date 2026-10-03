package com.demodd.application.geography.documenttype.port.in;

import java.util.UUID;

public interface DeleteDocumentTypeUseCase {

    void execute(UUID id);
}
