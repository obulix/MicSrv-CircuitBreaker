package com.dsigpattern.circuitbreaker.inventoryservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsigpattern.circuitbreaker.inventoryservice.domain.InventoryItem;
import com.dsigpattern.circuitbreaker.inventoryservice.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/items")
    public List<InventoryItem> getAllItems() {
        return inventoryService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Optional<InventoryItem> getItemById(@PathVariable Long id) {
        return inventoryService.getItemById(id);
    }

    @PostMapping("/items")
    public InventoryItem addItem(@RequestBody InventoryItem item) {
        return inventoryService.saveItem(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        inventoryService.deleteItem(id);
    }
    @PutMapping("items/{id}")
    public InventoryItem updateCustomer(@PathVariable Long id, @RequestBody InventoryItem updatedItem) {

    	return inventoryService.updateCustomer(id,updatedItem);
    }
    @GetMapping("/items/{id}/requestedQuantity/{qty}")
    public boolean checkInventoryAvailability(@PathVariable Long id,@PathVariable Integer qty) {
        return inventoryService.checkInventoryAvailability(id,qty);
    }
    
}