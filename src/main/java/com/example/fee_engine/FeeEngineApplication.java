package com.example.fee_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.fee_engine")
public class FeeEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeeEngineApplication.class, args);
	}

}
