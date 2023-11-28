package com.dsigpattern.circuitbreaker.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsigpattern.circuitbreaker.orderservice.domain.Order;
import com.dsigpattern.circuitbreaker.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

}