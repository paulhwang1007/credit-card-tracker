package com.example.credit_card_tracker;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    // Field
    private final CreditCardRepository creditCardRepository;

    // Constructor
    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    // Method
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }
}
