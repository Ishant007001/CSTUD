package com.xyz.card.service;

import com.xyz.card.model.Card;
import com.xyz.card.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CardValidationServiceTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardValidationService cardValidationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validateCardReturnsCard() {
        Card card = Card.builder().cardNumber("1234").valid(true).build();
        when(cardRepository.findById("1234")).thenReturn(Optional.of(card));

        Optional<Card> result = cardValidationService.validateCard("1234");

        assertTrue(result.isPresent());
        assertTrue(result.get().isValid());
    }
}
