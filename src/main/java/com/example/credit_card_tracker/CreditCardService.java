package com.example.credit_card_tracker;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
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

    public Optional<CreditCard> getCardById(long id) { return creditCardRepository.findById(id);}

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
            CreditCard updatedCard
    ) {
        CreditCard existingCard = creditCardRepository.findById(creditCardId).orElseThrow(
                () -> new IllegalStateException("Credit Card with ID " + creditCardId + " does not exist")
        );

        if (updatedCard.getName() != null && !updatedCard.getName().isEmpty()) {
            existingCard.setName(updatedCard.getName());
        }
        if (updatedCard.getBank() != null && !updatedCard.getBank().isEmpty()) {
            existingCard.setBank(updatedCard.getBank());
        }
        if (updatedCard.getAnnual_fee() != null) {
            existingCard.setAnnual_fee(updatedCard.getAnnual_fee());
        }

        if (updatedCard.getOpening_date() != null) {
            existingCard.setOpening_date(updatedCard.getOpening_date());
        }

        if (updatedCard.getMultipliers() != null && !updatedCard.getMultipliers().isEmpty()) {
            existingCard.setMultipliers(updatedCard.getMultipliers());
        }
        if (updatedCard.getWelcome_bonus() != null && !updatedCard.getWelcome_bonus().isEmpty()) {
            existingCard.setWelcome_bonus(updatedCard.getWelcome_bonus());
        }

    }
}
