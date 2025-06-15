package com.example.credit_card_tracker;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    // Field
    private final CreditCardRepository creditCardRepository;

    // Constructor
    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    // Methods
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    public void addCreditCard(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }

    public void removeCreditCard(Long creditCardId) {
        boolean exists = creditCardRepository.existsById(creditCardId);
        if (!exists) {
            throw new IllegalStateException("Credit Card with ID " + creditCardId + " does not exist.");
        }
        creditCardRepository.deleteById(creditCardId);
    }

    @Transactional
    public void updateCreditCard(Long creditCardId, String name, String bank) {
        CreditCard creditCard = creditCardRepository.findById(creditCardId).orElseThrow(
                () -> new IllegalStateException("Credit Card with ID " + creditCardId + " does not exist.")
        );

        if (name != null && !name.isEmpty() && !Objects.equals(creditCard.getName(), name)) {
            creditCard.setName(name);
        }

        if (bank != null && !bank.isEmpty() && !Objects.equals(creditCard.getBank(), bank)) {
            creditCard.setBank(bank);
        }
    }
}
