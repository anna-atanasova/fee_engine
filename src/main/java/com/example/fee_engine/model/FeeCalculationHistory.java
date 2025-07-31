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

    public FeeCalculationHistory(){}

    public FeeCalculationHistory(String transactionId){
        this.transactionId = transactionId;
    }
}
