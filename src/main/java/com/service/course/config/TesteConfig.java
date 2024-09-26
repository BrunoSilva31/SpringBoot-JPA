package com.service.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.service.course.entities.Category;
import com.service.course.entities.Order;
import com.service.course.entities.User;
import com.service.course.entities.enums.OrderStatus;
import com.service.course.repositories.CategoryRepository;
import com.service.course.repositories.OrderRepository;
import com.service.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Bjorn Ironside", "bjorndelas@gmail.com", "7199997777", "123456");
        User u2 = new User(null, "Ragnar Lothbrook", "calcapeluda@gmail.com", "7198884444", "654321");

        Order o1 = new Order(null, Instant.parse("2024-09-10T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2024-09-13T20:30:12Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2023-11-25T19:25:35Z"), u2, OrderStatus.WAITING_PAYMENT);

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }

    
}
