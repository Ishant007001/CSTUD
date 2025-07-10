package com.xyz.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{orderId}/process")
    public String processOrder(@PathVariable String orderId) {
        orderService.processOrder(orderId);
        return "Order processing started for " + orderId;
    }
}
