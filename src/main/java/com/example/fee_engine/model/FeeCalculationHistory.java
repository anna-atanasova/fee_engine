package com.example.fee_engine.model;

import jakarta.persistence.*;
import jakarta.persistence.Lob;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
public class FeeCalculationHistory {
    @Id
    @GeneratedValue
    private Long id;
    private String transactionId;
    @Lob
    private String requestJson;
    @Lob
    private String responseJson;
    private LocalDateTime timestamp;

    public FeeCalculationHistory(){}

    public FeeCalculationHistory(String transactionId, String requestJson, String responseJson, LocalDateTime timestamp){
        this.transactionId = transactionId;
        this.requestJson = requestJson;
        this.responseJson = responseJson;
        this.timestamp = timestamp;
    }
}
