package com.example.fee_engine.service.impl;

import com.example.fee_engine.dto.RuleResult;
import com.example.fee_engine.model.Transactions;
import com.example.fee_engine.repository.TransactionsRepository;
import com.example.fee_engine.ruleengine.RuleEngine;
import com.example.fee_engine.service.TransactionsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionsService {
    private final TransactionsRepository transactionsRepository;
    private final RuleEngine ruleEngine;

    public TransactionServiceImpl(TransactionsRepository transactionsRepository, RuleEngine ruleEngine) {
        this.transactionsRepository = transactionsRepository;
        this.ruleEngine = ruleEngine;
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

    public RuleResult calculateFee(Transactions transaction) {
        return ruleEngine.applyRules(transaction);
    }

    public List<RuleResult> calculateFeeBatch(List<Transactions> transactions) {
        List<RuleResult> results = new ArrayList<>();
        for (Transactions tx : transactions) {
            results.add(calculateFee(tx));
        }
        return results;
    }
}
