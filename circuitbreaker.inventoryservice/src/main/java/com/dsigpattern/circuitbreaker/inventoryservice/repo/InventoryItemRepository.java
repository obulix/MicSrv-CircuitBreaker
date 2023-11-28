package com.dsigpattern.circuitbreaker.inventoryservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.dsigpattern.circuitbreaker.inventoryservice.domain.InventoryItem;

public interface InventoryItemRepository extends CrudRepository<InventoryItem, Long> {
}
