package com.example.fee_engine.service;

import com.example.fee_engine.dto.RuleResult;
import com.example.fee_engine.model.Transactions;

import java.util.List;
import java.util.Optional;

public interface TransactionsService {
    Optional<Transactions> findById(Long id);

    List<Transactions> findAll();

    Optional<Transactions> save(Transactions ts);
    RuleResult calculateFee(Transactions transaction);
    List<RuleResult> calculateFeeBatch(List<Transactions> transactions);

}
