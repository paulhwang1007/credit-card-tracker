package com.example.credit_card_tracker;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/credit_card")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping
    public List<CreditCard> getCreditCard() {
        return creditCardService.getAllCreditCards();
    }

    @PostMapping
    public void postNewCreditCard(CreditCard creditCard) {
        creditCardService.addCreditCard(creditCard);
    }

    @DeleteMapping(path = "{creditCardId}")
    public void deleteCreditCard(@PathVariable("creditCardId") Long id) {
        creditCardService.removeCreditCard(id);
    }

    @PutMapping(path = "{creditCardId}")
    public void putCreditCard(
            @PathVariable("creditCardId") Long creditCardId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String bank
    ) {
        creditCardService.updateCreditCard(creditCardId, name, bank);
    }
}
