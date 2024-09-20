package com.service.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.service.course.entities.User;
import com.service.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Bjorn Ironside", "bjorndelas@gmail.com", "7199997777", "123456");
        User u2 = new User(null, "Ragnar Lothbrook", "calcapeluda@gmail.com", "7198884444", "654321");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }

    
}
