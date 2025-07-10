package com.xyz.payment.service;

import com.xyz.payment.client.CardValidationClient;
import com.xyz.payment.model.Payment;
import com.xyz.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CardValidationClient cardValidationClient;

    public Payment processPayment(Payment payment) {
        boolean isValid = cardValidationClient.validateCard(payment.getCardNumber()).isValid();
        payment.setSuccessful(isValid);
        return paymentRepository.save(payment);
    }
}
