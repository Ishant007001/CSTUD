package com.xyz.payment.service;

import com.xyz.payment.client.CardValidationClient;
import com.xyz.payment.dto.CardDto;
import com.xyz.payment.model.Payment;
import com.xyz.payment.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private CardValidationClient cardValidationClient;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessPaymentSuccess() {
        Payment payment = Payment.builder().cardNumber("1234").amount(100.0).build();
        CardDto cardDto = new CardDto();
        cardDto.setCardNumber("1234");
        cardDto.setValid(true);

        when(cardValidationClient.validateCard("1234")).thenReturn(cardDto);
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        Payment result = paymentService.processPayment(payment);
        assertTrue(result.isSuccessful());
    }
}
