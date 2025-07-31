package com.example.fee_engine.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
public class Transactions {
    @Id
    @GeneratedValue
    private Long id;
    private String transactionId;
    private String type;
    private BigDecimal amount;
    private String currency;
    private boolean isInternational;
    @ManyToOne
    private Client client;
    private int creditScore;
    private BigDecimal fee;

    public Transactions(){}

    public Long getId() {
        return id;
    }
    public String getType(){
        return type;
    }
    public BigDecimal getAmount(){
        return amount;
    }
    public String getCurrency(){
        return currency;
    }
    public boolean getIsInternational(){
        return isInternational;
    }
    public int getCreditScore(){
        return creditScore;
    }
    public Client getClient(){
        return client;
    }

    public BigDecimal getFee(){
        return fee;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
}
