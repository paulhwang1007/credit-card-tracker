package com.example.credit_card_tracker;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(path = "api/v1/credit_card")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    // GET Endpoint
    @GetMapping
    public List<CreditCard> getCreditCard() {
        return creditCardService.getAllCreditCards();
    }

    @GetMapping("/{id}")
    public Optional<CreditCard> getCreditCardById(@PathVariable long id) {
        return creditCardService.getCardById(id);
    }

    // POST Endpoint
    @PostMapping
    public void postNewCreditCard(@RequestBody CreditCard creditCard) {
        creditCardService.addCreditCard(creditCard);
    }

    // DELETE Endpoint
    @DeleteMapping(path = "{creditCardId}")
    public void deleteCreditCard(@PathVariable("creditCardId") Long id) {
        creditCardService.removeCreditCard(id);
    }

    // PUT Endpoint
    @PutMapping(path = "{creditCardId}")
    public void putCreditCard(
            @PathVariable("creditCardId") Long creditCardId,
            @RequestBody CreditCard updatedCard
    ) {
        creditCardService.updateCreditCard(creditCardId, updatedCard);
    }
}
