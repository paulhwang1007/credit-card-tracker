package com.example.credit_card_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CreditCardTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardTrackerApplication.class, args);
	}

}
