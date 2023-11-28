package com.dsigpattern.circuitbreaker.inventoryservice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsigpattern.circuitbreaker.inventoryservice.domain.InventoryItem;
import com.dsigpattern.circuitbreaker.inventoryservice.repo.InventoryItemRepository;

@Service
public class InventoryService {
    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    public List<InventoryItem> getAllItems() {
        return (List<InventoryItem>) inventoryItemRepository.findAll();
    }

    public Optional<InventoryItem> getItemById(Long id) {
        return inventoryItemRepository.findById(id);
    }

    public InventoryItem saveItem(InventoryItem item) {
        return inventoryItemRepository.save(item);
    }

    public void deleteItem(Long id) {
        inventoryItemRepository.deleteById(id);
    }
    public InventoryItem updateCustomer(Long id, InventoryItem updatedItem) {
    	updatedItem.setId(id);
    	return inventoryItemRepository.save(updatedItem);
    }
    public boolean checkInventoryAvailability(Long id, int requestedQuantity) {
        InventoryItem inventoryItem = inventoryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory item not found"));
        return inventoryItem.getQuantity() >= requestedQuantity;
    }
}