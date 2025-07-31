package com.example.fee_engine.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class RuleResult {

    private BigDecimal totalFee;
    private List<String> appliedRules;

    public RuleResult() {
        this.totalFee = BigDecimal.ZERO;
        this.appliedRules = new ArrayList<>();
    }

    public RuleResult(BigDecimal totalFee, List<String> appliedRules) {
        this.totalFee = totalFee;
        this.appliedRules = appliedRules;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public List<String> getAppliedRules() {
        return appliedRules;
    }

    public void setAppliedRules(List<String> appliedRules) {
        this.appliedRules = appliedRules;
    }

    public void addRule(String ruleName) {
        this.appliedRules.add(ruleName);
    }

    public void addFee(BigDecimal fee) {
        this.totalFee = this.totalFee.add(fee);
    }
}
