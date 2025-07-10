package com.xyz.card.controller;

import com.xyz.card.model.Card;
import com.xyz.card.service.CardValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cards")
public class CardValidationController {

    @Autowired
    private CardValidationService cardValidationService;

    @GetMapping("/validate/{cardNumber}")
    public ResponseEntity<Card> validateCard(@PathVariable String cardNumber) {
        Optional<Card> card = cardValidationService.validateCard(cardNumber);
        return card.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
