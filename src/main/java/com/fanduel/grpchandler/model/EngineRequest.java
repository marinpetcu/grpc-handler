package com.fanduel.grpchandler.model;

import java.math.BigDecimal;

public record EngineRequest(
        String requestId,
        Long userId,
        BigDecimal amount,
        String transactionRef
) {
}
