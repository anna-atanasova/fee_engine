package com.example.fee_engine.ruleengine.rules;

import com.example.fee_engine.model.Rule;
import com.example.fee_engine.model.Transactions;
import com.example.fee_engine.ruleengine.FeeRule;

import java.math.BigDecimal;

public class FixedFeeRule implements FeeRule {
    @Override
    public boolean applies(Transactions tx, Rule rule) {
        return tx.getType().equalsIgnoreCase("POS");
    }

    @Override
    public BigDecimal calculate(Transactions tx, Rule rule) {
        if(tx.getAmount().compareTo(BigDecimal.valueOf(100)) <= 0){
            return BigDecimal.valueOf(0.20);
        }
        else{
            return tx.getAmount().multiply(BigDecimal.valueOf(0.002));
        }
    }
}
