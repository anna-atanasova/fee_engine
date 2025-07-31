package com.example.fee_engine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String type;
    private String condition;

    public Rule(){}

    public Rule(String name, String description, String type, String condition){
        this.name = name;
        this.description = description;
        this.type = type;
        this.condition = condition;
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getType(){
        return type;
    }

    public String getCondition(){
        return condition;
    }
}
