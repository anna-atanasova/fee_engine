package com.example.fee_engine.service.impl;

import com.example.fee_engine.model.Rule;
import com.example.fee_engine.repository.RuleRepository;
import com.example.fee_engine.service.RuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuleServiceImpl implements RuleService {
    private final RuleRepository ruleRepository;

    public RuleServiceImpl(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public Optional<Rule> findById(Long id) {
        return ruleRepository.findById(id);
    }

    @Override
    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public Optional<Rule> save(Rule rule) {
        return Optional.of(ruleRepository.save(rule));
    }

    @Override
    public Optional<Rule> update(Long id, Rule rules) {
        Optional<Rule> optionalRule = ruleRepository.findById(id);
        if(optionalRule.isPresent()){
            Rule existingRule = optionalRule.get();
            existingRule.setName(rules.getName());
            existingRule.setDescription(rules.getDescription());
            existingRule.setType(rules.getType());
            existingRule.setCondition(rules.getCondition());
            return Optional.of(ruleRepository.save(existingRule));
        } else {
            throw new RuntimeException("Rule with id " + id + " not found");
        }
    }

    @Override
    public void delete(Long id) {
        ruleRepository.deleteById(id);
    }
}
