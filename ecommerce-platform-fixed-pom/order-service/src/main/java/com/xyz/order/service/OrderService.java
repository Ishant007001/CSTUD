package com.xyz.order.service;

import com.xyz.order.model.Order;
import com.xyz.order.observer.EmailNotifier;
import com.xyz.order.observer.OrderObserver;
import com.xyz.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private final OrderObserver observer = new EmailNotifier();

    public Order placeOrder(Order order) {
        order.setStatus("PROCESSING");
        Order savedOrder = orderRepository.save(order);

        Thread mainThread = new Thread(() -> processOrder(savedOrder));
        mainThread.start();

        return savedOrder;
    }

    package com.xyz.order;

    import org.springframework.stereotype.Service;

    @Service
    public class OrderService {

        public void processOrder(String orderId) {
            // Main thread: order processing
            Thread mainThread = new Thread(() -> {
                System.out.println("Order " + orderId + " is being processed...");
                try {
                    Thread.sleep(2000); // Simulating order processing delay
                    System.out.println("Order " + orderId + " processed. Starting payment validation...");

                    // Child thread: payment checking + notification
                    Thread childThread = new Thread(() -> {
                        try {
                            Thread.sleep(1500); // Simulate payment status check
                            boolean paymentSuccess = Math.random() > 0.5;
                            if (paymentSuccess) {
                                notifyCustomer(orderId, "Payment Successful");
                            } else {
                                notifyCustomer(orderId, "Payment Failed");
                            }
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.err.println("Child thread interrupted: " + e.getMessage());
                        }
                    });

                    childThread.start();
                    childThread.join(); // Wait for child thread to finish

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Main thread interrupted: " + e.getMessage());
                }
            });

            mainThread.start();
        }

        private void notifyCustomer(String orderId, String message) {
            System.out.println("Notification for Order " + orderId + ": " + message);
        }
    }

}
