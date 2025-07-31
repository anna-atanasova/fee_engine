package com.example.fee_engine.web;

import com.example.fee_engine.model.FeeCalculationHistory;
import com.example.fee_engine.service.HistoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@Tag(name = "History", description = "Fee Calculation History Endpoints")
public class HistoryController {

    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService){
        this.historyService = historyService;
    }

    @GetMapping
    public ResponseEntity<List<FeeCalculationHistory>> getAllHistory(){
        List<FeeCalculationHistory> histories = historyService.getAllHistory();
        return ResponseEntity.ok(histories);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<FeeCalculationHistory> getHistoryByTransactionId(String transactionId){
        FeeCalculationHistory history = historyService.getHistoryByTransactionId(transactionId);
        if(history != null){
            return ResponseEntity.ok(history);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
