package com.example.fee_engine.ruleengine;

import com.example.fee_engine.dto.RuleResult;
import com.example.fee_engine.model.Rule;
import com.example.fee_engine.model.Transactions;
import com.example.fee_engine.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RuleEngine {
    private final RuleRepository ruleRepository;

    public RuleEngine(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public RuleResult applyRules(Transactions tx) {
        BigDecimal totalFee = BigDecimal.ZERO;
        List<String> appliedRules = new ArrayList<>();

        List<Rule> dynamicRules = ruleRepository.findAll();

        for (Rule rule : dynamicRules) {
            boolean applies = evaluateCondition(rule.getCondition(), tx);
            if (applies) {
                BigDecimal fee = evaluateAction(rule.getAction(), tx);
                totalFee = totalFee.add(fee);
                appliedRules.add(rule.getName());
            }
        }

        return new RuleResult(totalFee, appliedRules);
    }

    private boolean evaluateCondition(String condition, Transactions tx) {
        try {
            ExpressionParser parser = new SpelExpressionParser();
            StandardEvaluationContext context = new StandardEvaluationContext();
            context.setVariable("tx", tx);
            return parser.parseExpression(condition).getValue(context, Boolean.class);
        } catch (Exception e) {
            return false;
        }
    }

    private BigDecimal evaluateAction(String action, Transactions tx) {
        try {
            ExpressionParser parser = new SpelExpressionParser();
            StandardEvaluationContext context = new StandardEvaluationContext();
            context.setVariable("tx", tx);
            return parser.parseExpression(action).getValue(context, BigDecimal.class);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }
}
