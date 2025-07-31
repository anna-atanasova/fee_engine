package com.example.fee_engine.ruleengine.rules;

import com.example.fee_engine.model.Rule;
import com.example.fee_engine.model.Transactions;
import com.example.fee_engine.ruleengine.FeeRule;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class FixedFeeRule implements FeeRule {


    @Override
    public boolean appliesTo(Transactions transaction) {
        return true;
    }

    @Override
    public BigDecimal apply(Transactions transaction) {
        return new BigDecimal("1.00");
    }

    @Override
    public String getName() {
        return "FixedFeeRule";
    }
}
