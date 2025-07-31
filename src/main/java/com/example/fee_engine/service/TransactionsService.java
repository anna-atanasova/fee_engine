package com.example.fee_engine.service;

import com.example.fee_engine.model.Client;
import com.example.fee_engine.model.Transactions;
import jakarta.transaction.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionsService {
    Optional<Transactions> findById(Long id);

    List<Transactions> findAll();

    Optional<Transactions> save(Transactions ts);

}
