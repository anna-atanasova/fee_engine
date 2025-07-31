package com.example.fee_engine.service;

import com.example.fee_engine.model.Client;
import com.example.fee_engine.model.Rule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface RuleService {
    Optional<Rule> findById(Long id);
    List<Rule> getAllRules();
    Optional<Rule> save(Rule rule);
    Optional<Rule> update(Long id, Rule rule);
    void delete(Long id);
}
