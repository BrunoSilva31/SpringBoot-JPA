package com.service.course.resourcers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.course.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    
    @GetMapping
    public ResponseEntity<User> findAll() {
        
        User u = new User(1L, "bruno@gmail.com", "Bruno", "senhaloka", "99999999");

        return ResponseEntity.ok().body(u);
    }
}
