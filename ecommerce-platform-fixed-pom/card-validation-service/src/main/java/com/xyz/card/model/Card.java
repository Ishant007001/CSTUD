package com.xyz.card.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Card {
    @Id
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private boolean valid;
}
