package com.fanduel.grpchandler.model;

import java.math.BigDecimal;

public record HandlerRequest(
        String requestId,
        Long userId,
        BigDecimal amount,
        String transactionRef
) {
}
