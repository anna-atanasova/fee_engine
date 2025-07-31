package com.example.fee_engine.web;

import com.example.fee_engine.model.Transactions;
import com.example.fee_engine.dto.RuleResult;
import com.example.fee_engine.service.TransactionsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Transactions", description = "Transactions Management Endpoints")
public class TransactionController {

    private final TransactionsService transactionsService;
    @Autowired
    public TransactionController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }
    @PostMapping("/calculate")
    public ResponseEntity<RuleResult> calculateFee(@RequestBody Transactions transaction) {
        RuleResult result = transactionsService.calculateFee(transaction);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/calculate-batch")
    public ResponseEntity<List<RuleResult>> calculateFeeBatch(@RequestBody List<Transactions> transactions) {
        List<RuleResult> results = transactionsService.calculateFeeBatch(transactions);
        return ResponseEntity.ok(results);
    }
}
