package com.example.fee_engine.dto;

import java.math.BigDecimal;
import java.util.List;

public record TransactionResponse(
        String transactionId,
        BigDecimal fee,
        List<String> appliedRules
) {}
