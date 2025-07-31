package com.example.fee_engine.ruleengine.rules;

import com.example.fee_engine.model.Rule;
import com.example.fee_engine.model.Transactions;
import com.example.fee_engine.ruleengine.FeeRule;

import java.math.BigDecimal;

public class ECommerceRule implements FeeRule {
    @Override
    public boolean applies(Transactions tx, Rule rule) {

        return tx.getType().equalsIgnoreCase("ECOMMERCE");
    }

    @Override
    public BigDecimal calculate(Transactions tx, Rule rule) {
        BigDecimal fee = tx.getAmount()
                .multiply(BigDecimal.valueOf(0.018))
                .add(BigDecimal.valueOf(0.15));
        return fee.min(BigDecimal.valueOf(120));
    }
}
