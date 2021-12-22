package com.workshopspringboot.workshopspringboot.config;

import com.workshopspringboot.workshopspringboot.data.OrderRepository;
import com.workshopspringboot.workshopspringboot.data.UserRepository;
import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import com.workshopspringboot.workshopspringboot.domain.entities.User;
import com.workshopspringboot.workshopspringboot.domain.enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        var u1 = new User(null, "Test one", "testOne@test.com",  "999999991", "123456");
        var u2 = new User(null, "Test Two", "testTwo@test.com",  "999999992", "123456");

        var o1 = new Order(null, u1, OrderStatusEnum.PAID);
        var o2 = new Order(null, u1, OrderStatusEnum.WAITING_PAYMENT);
        var o3 = new Order(null, u2, OrderStatusEnum.CANCELED);
        var o4 = new Order(null, u2, OrderStatusEnum.DELIVERED);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
    }
}
