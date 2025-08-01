package com.example.fee_engine.ruleengine.rules;

import com.example.fee_engine.model.Rule;
import com.example.fee_engine.model.Transactions;
import com.example.fee_engine.ruleengine.FeeRule;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class ECommerceRule implements FeeRule {
    @Override
    public boolean appliesTo(Transactions transaction) {
        return "e-commerce".equalsIgnoreCase(transaction.getType());
    }

    @Override
    public BigDecimal apply(Transactions transaction) {
        return new BigDecimal("0.50");
    }

    @Override
    public String getName() {
        return "ECommerceRule";
    }
}
