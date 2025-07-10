package com.xyz.card.service;

import com.xyz.card.model.Card;
import com.xyz.card.repository.CardRepository;
import com.xyz.common.logger.LoggerUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardValidationService {

    private static final Logger logger = LoggerUtil.getLogger(CardValidationService.class);

    @Autowired
    private CardRepository cardRepository;

    public Optional<Card> validateCard(String cardNumber) {
        logger.info("Validating card: {}", cardNumber);
        return cardRepository.findById(cardNumber);
    }
}
