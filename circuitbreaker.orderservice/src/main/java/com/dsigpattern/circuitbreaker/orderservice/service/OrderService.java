package com.dsigpattern.circuitbreaker.orderservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsigpattern.circuitbreaker.orderservice.domain.Order;
import com.dsigpattern.circuitbreaker.orderservice.feign.InventoryClient;
import com.dsigpattern.circuitbreaker.orderservice.repo.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryClient inventoryClient;
    
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @CircuitBreaker(name="checkInventoryAvailability", fallbackMethod="fallBackInventoryAilability")
    public Order placeOrder(Order order) {
        boolean isAvailable = inventoryClient.checkInventoryAvailability(order.getInventoryItemId(), order.getQuantity());

        if (isAvailable) {
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Insufficient inventory for the order");
        }
    }
    public Order fallBackInventoryAilability(Order order,Throwable throwable)
    {
    	logger.info("Check Inventory availability method is not work at this point of time.");
    	return null;
    }
}