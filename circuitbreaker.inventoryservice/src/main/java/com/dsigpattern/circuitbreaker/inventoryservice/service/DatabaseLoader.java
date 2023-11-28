package com.dsigpattern.circuitbreaker.inventoryservice.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dsigpattern.circuitbreaker.inventoryservice.domain.InventoryItem;
import com.dsigpattern.circuitbreaker.inventoryservice.repo.InventoryItemRepository;


@Configuration
public class DatabaseLoader {

	@Bean
	CommandLineRunner init(InventoryItemRepository repository) {
		return args -> {
			repository.save(new InventoryItem("Gandhi Bar Soap",25));
			repository.save(new InventoryItem("555 soap",100));
			repository.save(new InventoryItem("Nirma",12));
			repository.save(new InventoryItem("Medimix",56));
			repository.save(new InventoryItem("Hamam",75));
		};
	}
}