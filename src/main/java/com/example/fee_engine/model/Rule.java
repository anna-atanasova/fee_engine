package com.example.fee_engine.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.Data;

@Entity
@Data
public class Rule {
    @Id
    @GeneratedValue
    private String id;
    private String description;
    private String condition;
    private String expression;

    public Rule(){}

    public Rule(String description, String condition, String expression){
        this.description = description;
        this.condition = condition;
        this.expression = expression;
    }
}
