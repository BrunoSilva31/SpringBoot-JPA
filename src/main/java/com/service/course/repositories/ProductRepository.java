package com.service.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.course.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {}
