package com.example.fee_engine.repository;

import com.example.fee_engine.model.FeeCalculationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<FeeCalculationHistory, Long> {
    List<FeeCalculationHistory> findByTransactionId(String transactionId);
}
