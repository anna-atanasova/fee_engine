package com.example.fee_engine.dto;

import java.math.BigDecimal;

public record TransactionRequest(
        String transactionId,
        String type,
        BigDecimal amount,
        String currency,
        boolean isInternational,
        ClientData client
)
{

}
