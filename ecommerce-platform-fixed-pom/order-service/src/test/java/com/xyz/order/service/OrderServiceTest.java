package com.xyz.order.service;

import com.xyz.order.model.Order;
import com.xyz.order.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPlaceOrderStartsThread() {
        Order order = Order.builder().product("Book").quantity(1).amount(50.0).cardNumber("1234").build();
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order result = orderService.placeOrder(order);

        assert result.getStatus().equals("PROCESSING");
    }
}
