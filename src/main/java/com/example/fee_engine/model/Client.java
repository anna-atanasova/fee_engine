package com.example.fee_engine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    int creditScore;
    private String segment;

    public  Client(){}
    public  Client(String name, int creditScore, String segment){
        this.name = name;
        this.creditScore = creditScore;
        this.segment = segment;
    }
    public Long getId() {
        return id;
    }

    public String getSegment(){
        return segment;
    }

    public Long getCreditScore(){
        return (long) creditScore;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
