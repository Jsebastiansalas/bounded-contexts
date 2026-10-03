package com.demodd.application.chat.sendertype.port.in;

import com.demodd.application.chat.sendertype.dto.SenderTypeResponse;

public interface CreateSenderTypeUseCase {

    SenderTypeResponse execute(String name);
}
