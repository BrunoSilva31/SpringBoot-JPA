package com.service.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.course.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
