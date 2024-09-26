package com.service.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.course.entities.Category;

public interface CategoryRepository extends  JpaRepository<Category, Long>{

}
