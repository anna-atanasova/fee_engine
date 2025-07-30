package com.example.fee_engine.dto;

public record ClientData(
        String clientId,
        int creditScore,
        String segment
) {}
