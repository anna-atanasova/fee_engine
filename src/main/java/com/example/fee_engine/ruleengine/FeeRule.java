package com.example.fee_engine.ruleengine;

import com.example.fee_engine.model.Rule;
import com.example.fee_engine.model.Transactions;
import jakarta.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public interface FeeRule {
    boolean applies(Transactions tx, Rule rule);
    BigDecimal calculate(Transactions tx, Rule rule);
}
