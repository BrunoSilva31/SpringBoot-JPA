package com.service.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.course.entities.Order;

public interface  OrderRepository extends JpaRepository<Order, Long>{}
