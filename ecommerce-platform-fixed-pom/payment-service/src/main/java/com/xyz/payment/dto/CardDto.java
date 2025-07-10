package com.xyz.payment.dto;

import lombok.Data;

@Data
public class CardDto {
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private boolean valid;
}
