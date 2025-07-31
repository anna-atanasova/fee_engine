package com.example.fee_engine.ruleengine;

import com.example.fee_engine.model.Rule;
import com.example.fee_engine.model.Transactions;
import jakarta.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface FeeRule {
    boolean appliesTo(Transactions transaction);
    BigDecimal apply(Transactions transaction);
    String getName();
}
