package com.dsigpattern.circuitbreaker.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service",url = "http://localhost:9090/inventory")
public interface InventoryClient {
    @GetMapping("/items/{id}/requestedQuantity/{quantity}")
    boolean checkInventoryAvailability(@PathVariable Long id, @PathVariable int quantity);
}