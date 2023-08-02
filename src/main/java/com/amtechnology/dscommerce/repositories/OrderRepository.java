package com.amtechnology.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amtechnology.dscommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	
}
