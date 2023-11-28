package com.dsigpattern.circuitbreaker.orderservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.dsigpattern.circuitbreaker.orderservice.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
