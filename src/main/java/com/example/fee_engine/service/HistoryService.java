package com.example.fee_engine.service;

import com.example.fee_engine.model.FeeCalculationHistory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface HistoryService {
    Optional<FeeCalculationHistory> save(FeeCalculationHistory history);
    List<FeeCalculationHistory> findAll();
    Optional<FeeCalculationHistory> findById(Long id);
    List<FeeCalculationHistory> findByTransactionId(String transactionId);
}
