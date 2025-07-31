package com.example.fee_engine.service.impl;

import com.example.fee_engine.model.FeeCalculationHistory;
import com.example.fee_engine.repository.HistoryRepository;
import com.example.fee_engine.service.HistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public Optional<FeeCalculationHistory> save(FeeCalculationHistory history) {
        return Optional.of(historyRepository.save(history));
    }

    @Override
    public List<FeeCalculationHistory> findAll() {
        return historyRepository.findAll();
    }

    @Override
    public Optional<FeeCalculationHistory> findById(Long id) {
        return historyRepository.findById(id);
    }

    @Override
    public List<FeeCalculationHistory> findByTransactionId(String transactionId) {
        return historyRepository.findByTransactionId(transactionId);
    }
}
