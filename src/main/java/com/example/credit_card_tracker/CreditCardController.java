package com.example.credit_card_tracker;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/credit_card")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping
    public List<CreditCard> getCreditCards() {
        return creditCardService.getAllCreditCards();
    }
}


//return List.of(
//                new CreditCard(
//                1,
//                        "Discover IT",
//                                "Capital One",
//                                0,
//        LocalDate.of(2023, Month.NOVEMBER, 4),
//                        List.of(
//                                "5% Cashback on quarterly select shops",
//                                        "1% Cashback on all other purchases"
//),
//                        "Unlimited Cashback on all Purchases for the 1st Year"
//                                ),
//                                new CreditCard(
//                        2,
//                                "Freedom Unlimited",
//                                "Chase",
//                                0,
//        LocalDate.of(2025, Month.MARCH, 23),
//                        List.of(
//                                "3% Cashback on Dining, including takeout and delivery",
//                                        "3% Cashback on Drugstore purchases",
//                                        "5% Cashback on travel booked through Chase Travel",
//                                        "1.5% Cashback on all other purchases"
//),
//                        "$200 bonus in points after spending $500 in the first 3 months"
//                                )
//                                );