package com.example.fee_engine.web;

import com.example.fee_engine.model.Rule;
import com.example.fee_engine.service.RuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Rules", description = "Rule Management Endpoints")
public class RuleController {

    private final RuleService ruleService;

    @Autowired
    public RuleController(RuleService ruleService){
        this.ruleService = ruleService;
    }

    @GetMapping
    public ResponseEntity<List<Rule>> getAllRules(){
        List<Rule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(rules);
    }

    @PostMapping
    public ResponseEntity<Optional<Rule>> addRule(@RequestBody Rule rule){
        Optional<Rule> savedRule = ruleService.save(rule);
        return ResponseEntity.ok(savedRule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Rule>> updateRule(@PathVariable Long id, @RequestBody Rule rule){
        Optional<Rule> updatedRule = ruleService.update(id, rule);
        return ResponseEntity.ok(updatedRule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id){
        ruleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
