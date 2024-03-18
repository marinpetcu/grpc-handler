package com.fanduel.grpchandler.model;

import java.math.BigDecimal;

public record EntryFeeRequest(
        String requestId,
        BigDecimal amount,
        String transactionRef
) {
}
