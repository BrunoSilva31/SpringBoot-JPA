package com.service.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.course.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {}
