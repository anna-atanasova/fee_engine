package com.example.fee_engine.service.impl;

import com.example.fee_engine.model.Transactions;
import com.example.fee_engine.repository.TransactionsRepository;
import com.example.fee_engine.service.TransactionsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionsService {
    private final TransactionsRepository transactionsRepository;

    public TransactionServiceImpl(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @Override
    public Optional<Transactions> findById(Long id) {
        return transactionsRepository.findById(id);
    }

    @Override
    public List<Transactions> findAll() {
        return transactionsRepository.findAll();
    }

    @Override
    public Optional<Transactions> save(Transactions ts) {
        return Optional.of(transactionsRepository.save(ts));
    }
}
