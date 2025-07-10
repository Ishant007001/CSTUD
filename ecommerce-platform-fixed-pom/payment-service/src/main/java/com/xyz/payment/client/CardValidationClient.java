package com.xyz.payment.client;

import com.xyz.payment.dto.CardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "card-validation-client", url = "http://localhost:8082")
public interface CardValidationClient {

    @GetMapping("/api/cards/validate/{cardNumber}")
    CardDto validateCard(@PathVariable("cardNumber") String cardNumber);
}
