package com.example.credit_card_tracker;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditCardConfig {

    @Bean
    CommandLineRunner commandLineRunner(CreditCardRepository repository) {
        return args -> {

//            CreditCard discover_it = new CreditCard(
//                    "Discover iT",
//                    "Capital One",
//                    0,
//                    LocalDate.of(2023, Month.NOVEMBER, 4),
//                    List.of("5% Cashback on quarterly select shops",
//                            "1% Cashback on all other purchase"),
//                    "Unlimited Cashback on all purchases for the 1st Year"
//            );
//
//            CreditCard chase_ful = new CreditCard(
//                    "Freedom Unlimited",
//                    "Chase",
//                    0,
//                    LocalDate.of(2025, Month.MARCH, 23),
//                    List.of("3% Cashback on Dining, including takeout and delivery",
//                            "3% Cashback on Drugstore purchases",
//                            "5% Cashback on travel booked through Chase Travel",
//                            "1.5% Cashback on all other purchases"),
//                    "$200 bonus in points after spending $500 in the first 3 months"
//            );
//
//            repository.saveAll(
//                    List.of(discover_it, chase_ful)
//            );

        };
    }
}