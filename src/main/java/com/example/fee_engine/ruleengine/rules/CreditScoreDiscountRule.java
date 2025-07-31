package com.example.fee_engine.ruleengine.rules;

import com.example.fee_engine.model.Rule;
import com.example.fee_engine.model.Transactions;
import com.example.fee_engine.ruleengine.FeeRule;
import jakarta.persistence.Entity;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

public class CreditScoreDiscountRule implements FeeRule {
    @Override
    public boolean applies(Transactions tx, Rule rule) {
        return tx.getCreditScore() > 400;
    }

    @Override
    public BigDecimal calculate(Transactions tx, Rule rule) {
        return tx.getAmount().multiply(BigDecimal.valueOf(-0.01));
    }
}
