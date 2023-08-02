package com.amtechnology.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amtechnology.dscommerce.entities.OrderItem;
import com.amtechnology.dscommerce.entities.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
	
	
}
