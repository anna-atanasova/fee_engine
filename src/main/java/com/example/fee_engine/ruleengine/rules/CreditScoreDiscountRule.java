package com.example.fee_engine.ruleengine.rules;

import com.example.fee_engine.model.Transactions;
import com.example.fee_engine.ruleengine.FeeRule;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class CreditScoreDiscountRule implements FeeRule {
    @Override
    public boolean appliesTo(Transactions transaction) {
        return transaction.getCreditScore() >= 700;
    }

    @Override
    public BigDecimal apply(Transactions transaction) {
        return new BigDecimal("-0.25");
    }

    @Override
    public String getName() {
        return "CreditScoreDiscountRule";
    }
}
