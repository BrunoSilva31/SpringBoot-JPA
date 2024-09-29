package com.service.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.service.course.entities.Category;
import com.service.course.entities.Order;
import com.service.course.entities.OrderItem;
import com.service.course.entities.Payment;
import com.service.course.entities.Product;
import com.service.course.entities.User;
import com.service.course.entities.enums.OrderStatus;
import com.service.course.repositories.CategoryRepository;
import com.service.course.repositories.OrderItemRepository;
import com.service.course.repositories.OrderRepository;
import com.service.course.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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

        Product p1 = new Product(null, "Lord of the Rings", "Um, dois", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Três idiozinhos", 2190.0, "");
        Product p3 = new Product(null, "MacBook Pro", "Quatro, cinco", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Seis idiozinhos", 1200.0, "");
        Product p5 = new Product(null, "Rails of Dummies", "Sete, oito", 100.9, "");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        OrderItem oi1 = new OrderItem(o1, p1, p1.getPrice(), 2);
        OrderItem oi2 = new OrderItem(o1, p3, p4.getPrice(), 1);
        OrderItem oi3 = new OrderItem(o2, p3, p1.getPrice(), 2);
        OrderItem oi4 = new OrderItem(o3, p5, p5.getPrice(), 2);

        Payment pay1 = new Payment(null, Instant.parse("2024-09-10T21:53:07Z"), o1);

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        o1.setPayment(pay1);
        orderRepository.save(o1);
    }

    
}
