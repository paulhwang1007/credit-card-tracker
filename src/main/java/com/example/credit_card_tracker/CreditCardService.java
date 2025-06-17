package com.example.credit_card_tracker;

import jakarta.transaction.Transactional;
import java.time.DateTimeException;
import java.time.LocalDate;
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

    // Logic for GET Endpoint
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    // Logic for POST Endpoint
    public void addCreditCard(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }

    // Logic for DELETE Endpoint
    public void removeCreditCard(Long creditCardId) {
        boolean exists = creditCardRepository.existsById(creditCardId);
        if (!exists) {
            throw new IllegalStateException("Credit Card with ID " + creditCardId + " does not exist.");
        }
        creditCardRepository.deleteById(creditCardId);
    }

    // Logic for PUT Endpoint
    @Transactional
    public void updateCreditCard(
            Long creditCardId,
            String name,
            String bank,
            Integer annual_fee,
            String openingDateString,
            List<String> multipliers,
            String welcome_bonus
    ) {

        CreditCard creditCard = creditCardRepository.findById(creditCardId).orElseThrow(
                () -> new IllegalStateException("Credit Card with ID " + creditCardId + " does not exist.")
        );

        // Editing Name
        if (name != null && !name.isEmpty() && !Objects.equals(creditCard.getName(), name)) {
            creditCard.setName(name);
        }

        // Editing Bank
        if (bank != null && !bank.isEmpty() && !Objects.equals(creditCard.getBank(), bank)) {
            creditCard.setBank(bank);
        }

        // Editing Annual Fee
        if (annual_fee != null) {
            creditCard.setAnnual_fee(annual_fee);
        }

        // Editing Opening Date
        if (openingDateString != null && !openingDateString.isEmpty()) {
            try {
                LocalDate parsedDate = LocalDate.parse(openingDateString);
                creditCard.setOpening_date(parsedDate);
            } catch (DateTimeException e) {
                throw new IllegalStateException("Invalid Date Format: Use yyyy-MM-dd.");
            }
        }

        // Editing Multipliers
        if (multipliers != null && !multipliers.isEmpty()) {
            creditCard.setMultipliers(multipliers);
        }

        // Editing Welcome Bonus
        if (welcome_bonus != null && !welcome_bonus.isEmpty()) {
            creditCard.setWelcome_bonus(welcome_bonus);
        }

    }
}
